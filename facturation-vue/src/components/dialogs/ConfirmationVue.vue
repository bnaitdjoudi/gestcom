<template>
    <Dialog
        :header="title"
        :visible.sync="display"
        :style="{width: '50vw'}">
        <div class="p-grid">
            <div class="p-col-12 p-md-2">
                <label htmlFor="input">Libellie</label>
            </div>
            <div class="p-col-12 p-md-4">
                <span>{{message}}</span>
            </div>
        </div>
        <template #footer>
            <Button
                label="Confirmer"
                icon="pi pi-check"
                class="p-button-success"
                @click="validate()" />
            <Button
                label="Annuler"
                icon="pi pi-times"
                class="p-button-danger"
                @click="close()" />
        </template>
    </Dialog>
</template>

<script>
export default {
    data(){
        return {cdisplay:this.display}
    }
    ,

    props: {
        title:String,
        message:String,
        process:Object,
        display:Boolean
    },
   
    methods: {
       close(){
           this.$emit('close');
       },
       validate(){
           this.$emit('validate');
       }
    }
}
</script>
