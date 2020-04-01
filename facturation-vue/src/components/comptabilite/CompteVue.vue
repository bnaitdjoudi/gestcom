<template>
    <div class="p-grid">
        <div class="p-col-12">
            <div class="card card-w-title">
                <h1>Categories</h1>
                <DataTable
                    :value="dataTableCats"
                    class="p-datatable-responsive"
                    selectionMode="single"
                    sortMode="multiple"
                    dataKey="id"
                    :paginator="true"
                    :rows="numberOfElements"
                    :totalRecords="totalOfElements"
                    :loading="loading"
                    :lazy="true"
                    :page="pageNumber"
                    :multiSortMeta="multiSortMeta"
                    @page="onPage($event)"
                    @sort="onPage($event)">
                    <template #header>
                        Liste des Categories
                        <div class="p-grid p-nogutter">
                            <div
                                class="p-col-6"
                                style="text-align: left">
                                <div class="p-inputgroup">
                                    <InputText
                                        v-model="text"
                                        placeholder="Rechercher" />
                                    <Button
                                        icon="pi pi-search"
                                        @click="onPage(null)" />
                                </div>
                            </div>
                            <div
                                class="p-col-6"
                                style="text-align: right">
                                <Button
                                    icon="pi pi-plus"
                                    @click="openEditDialog()" />
                            </div>
                        </div>
                    </template>
                    <Column
                        field="scfcod"
                        header="Code"
                        :sortable="true" />

                    <Column
                        field="libelle"
                        header="Désignation"
                        :sortable="true" />
                    <Column
                        field="dateCreate"
                        header="Date de création"
                        :sortable="true"
                        filterMatchMode="contains" />

                    <Column
                        headerStyle="width: 8em; text-align: center"
                        bodyStyle="text-align: center">
                        <template #body="slotProps">
                            <Button
                                type="button"
                                icon="pi pi-trash"
                                class="p-button-danger"
                                style="margin-right: .5em"
                                :data="slotProps.data"
                                @click="openConfirmation(slotProps.data.id)"></Button>
                            <Button
                                type="button"
                                icon="pi pi-pencil"
                                class="p-button-warning"
                                :data="slotProps.data"
                                @click="update(slotProps.data)"></Button>
                        </template>
                    </Column>
                </DataTable>
            </div>
        </div>
        <Dialog
            header="Ajouter Categorie Produit"
            :visible.sync="display"
            :style="{width: '50vw'}">
            <div class="p-grid">
                <div class="p-col-12 p-md-2">
                    <label htmlFor="input">Libellie</label>
                </div>
                <div class="p-col-12 p-md-4">
                    <InputText
                        ref="libinput"
                        id="input"
                        v-model="libellie"
                        :aria-required="true"
                        :class="sinput" />
                </div>

                <div class="p-col-12 p-md-2">
                    <label htmlFor="input">Code</label>
                </div>
                <div class="p-col-12 p-md-4">
                    <InputText
                        ref="libinput"
                        id="input"
                        v-model="scfcod"
                        :aria-required="true"
                        :class="sinput2" />
                </div>
            </div>
            <template #footer>
                <Button
                    label="Valider"
                    icon="pi pi-check"
                    class="p-button-success"
                    @click="save()" />
                <Button
                    label="Annuler"
                    icon="pi pi-times"
                    class="p-button-danger"
                    @click="close()" />
            </template>
        </Dialog>
        <ConfirmationVue
            v-bind:display="displayConfim"
            title="confirmation"
            message="Voulez vous vraiment suprimer cette Categorie?"
            v-on:validate="processDelete()"
            v-on:close="closeConfirmation()" />
    </div>
</template>

<script>
import CompteService from '../../service/CompteService';
import ConfirmationVue from '../dialogs/ConfirmationVue';
export default {
    data() {
        return {
            dataTableCats: [],
            multiSortMeta: [],
            sort: {},
            filters: {},
            text: null,
            pageNumber: 1,
            numberOfElements: 10,
            totalOfElements: 28,
            loading: true,
            display: false,
            libellie: null,
            scfcod: null,
            code: null,
            sinput: "",
            sinput2: "",
            selectedId: null,
            isUpdate: false,
            displayConfim: false

        }
    },
    components: {

        ConfirmationVue

    },
    carService: null,
    compteService: null,

    created() {

        this.compteService = new CompteService();
    },
    mounted() {
        this.compteService.getCompteByCriteria(1, 10).then(data => {
            this.dataTableCats = data.rows;
            this.totalOfElements = data.totalOfElements;
            this.loading = false;
        });
    },
    methods: {
        openEditDialog() {
            this.display = true;
            if(!this.isUpdate){
                this.scfcod="";
                this.libellie="";
            }
        },
        close() {
            this.display = false;
        },
        save() {
            if (this.libellie === "" || this.libellie == null) {
                this.sinput = "p-error";
            } else {
                if (this.scfcod === "" || this.scfcod == null) {
                    this.sinput2 = "p-error";
                } else {
                    if (!this.isUpdate) {
                        this.compteService.newCompte(this.code, this.libellie).then(resp => {
                            this.requestReturn(resp);
                        });
                    } else {
                        this.compteService.updateCompte(this.selectedId, this.scfcod, this.libellie).then(resp => {
                            this.requestReturn(resp);
                            this.isUpdate=false;
                        });
                    }

                }
            }
        },
        update(data) {

            this.libellie = data.libelle;
            this.scfcod = data.scfcod;
            this.selectedId = data.id;
            this.isUpdate = true;
            this.openEditDialog();

        },
        requestReturn(resp) {

            if (resp.status == 201 || resp.status == 204 || resp.status == 202) {
                this.loading = true;
                this.compteService.getCompteByCriteria(1, this.numberOfElements).then(data => {
                    this.dataTableCats = data.rows;
                    this.totalOfElements = data.totalOfElements;
                    this.pageNumber = 1;
                    this.loading = false;
                    this.display = false;
                });
            }
        },
        openConfirmation(id) {
            this.selectedId = id;
            this.displayConfim = true;

        },

        closeConfirmation() {

            this.displayConfim = false;

        },
        processDelete() {
            this.compteService.deleteCompte(this.selectedId).then(resp => {
                this.requestReturn(resp);
                this.displayConfim = false;
            });
        },

        onPage(event) {

            if (event != null && event.multiSortMeta) {
                this.multiSortMeta = event.multiSortMeta;
            }

            this.processSort(this.multiSortMeta);
            this.processFilter();
            this.compteService.getCompteByCriteria(((event != null && event.page) ? event.page : 0) + 1,
                this.numberOfElements, this.filters, this.sort).then(data => {
                this.dataTableCats = data.rows;
                this.totalOfElements = data.totalOfElements;
                this.loading = false;
            });
        },
        processSort(multiSortMeta) {
            if (multiSortMeta) {
                this.sort = {};
                for (var i = 0; i < multiSortMeta.length; i++) {
                    var order = "";
                    if (multiSortMeta[i].order > 0) {
                        order = "ASC";
                    } else {
                        order = "DESC";
                    }
                    var field = multiSortMeta[i].field;
                    this.sort[field] = order;
                }
            }
        },
        processFilter() {
            this.filters = {};
            if (this.text) {
                this.filters["libelle"] = { operator: "LIKE", value: this.text };
            }
        }
    }
}
</script>

<style lang="scss" scoped>
.p-column-filter {
    margin-top: .5em;
}

.p-dropdown {
    width: 12em;
}

.p-dataview {
    .car-details {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 2em;

        &>div {
            display: flex;
            align-items: center;

            img {
                margin-right: 14px;
            }
        }
    }

    .car-detail {
        padding: 0 1em 1em 1em;
        margin: 1em;
    }
}

.p-carousel {
    .p-carousel-content {
        .p-carousel-item {
            .car-details {
                >.p-grid {
                    border: 1px solid #b3c2ca;
                    border-radius: 3px;
                    margin: .3em;
                    text-align: center;
                    padding: 2em 0 2.25em 0;
                }
            }

            .car-data {
                .car-title {
                    font-weight: 700;
                    font-size: 20px;
                    margin-top: 24px;
                }

                .car-subtitle {
                    margin: .25em 0 2em 0;
                }

                button {
                    margin-left: .5em;

                    &:first-child {
                        margin-left: 0;
                    }
                }
            }
        }
    }
}

@media (max-width: 1024px) {
    .p-dataview {
        .car-details {
            img {
                width: 75px;
            }
        }
    }
}

.p-dropdown-car-option {
    img {
        vertical-align: middle;
        margin-right: .5em;
        width: 24px;
    }

    span {
        float: right;
        margin-top: .125em;
    }
}

body .p-dialog .p-dialog-content {
    line-height: 1.5;
}
</style>
