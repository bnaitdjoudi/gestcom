export default {
    data:[
        {label: 'Tableau de bord', icon: 'pi pi-fw pi-home', to: '/'},
        {
            label: 'Commercial', icon: 'pi pi-fw pi-cog',
            items: [
                {label: 'Facturation', icon: 'pi pi-fw pi-bars',  to: '/sample' },
                {label: 'Bon de livraison', icon: 'pi pi-fw pi-bars',  to: '/sample' },
                {label: 'Devis', icon: 'pi pi-fw pi-bars',  to: '/sample' }
            ]
        },
        {
            label: 'Produits', icon: 'pi pi-fw pi-align-left',  to :'/produit',
            items: [
                {label: 'Liste des produit', icon: 'pi pi-fw pi-list',  to: '/sample' },
                {label: 'Catégories de produit', icon: 'pi pi-fw pi-bars', to: '/categories' }
            ]
        }]
    
    /*[
        {label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/'},
        {
            label: 'Menu Modes', icon: 'pi pi-fw pi-cog',
            items: [
                {label: 'Static Menu', icon: 'pi pi-fw pi-bars',  command: () => this.layoutMode = 'static' },
                {label: 'Overlay Menu', icon: 'pi pi-fw pi-bars',  command: () => this.layoutMode = 'overlay' }
            ]
        },
        {
            label: 'Menu Colors', icon: 'pi pi-fw pi-align-left', 
            items: [
                {label: 'Dark', icon: 'pi pi-fw pi-bars',  command: () => this.layoutColorMode = 'dark' },
                {label: 'Light', icon: 'pi pi-fw pi-bars',  command: () => this.layoutColorMode = 'light' }
            ]
        },
        {
            label: 'Components', icon: 'pi pi-fw pi-globe', badge: '9',
            items: [
                {label: 'Sample Page', icon: 'pi pi-fw pi-th-large', to: '/sample'},
                {label: 'Forms', icon: 'pi pi-fw pi-file', to: '/forms'},
                {label: 'Data', icon: 'pi pi-fw pi-table', to: '/data'},
                {label: 'Panels', icon: 'pi pi-fw pi-list', to: '/panels'},
                {label: 'Overlays', icon: 'pi pi-fw pi-clone', to: '/overlays'},
                {label: 'Menus', icon: 'pi pi-fw pi-plus', to: '/menus'},
                {label: 'Messages', icon: 'pi pi-fw pi-spinner',to: '/messages'},
                {label: 'Charts', icon: 'pi pi-fw pi-chart-bar', to: '/charts'},
                {label: 'Misc', icon: 'pi pi-fw pi-upload', to: '/misc'}
            ]
        },
        {
            label: 'Template Pages', icon: 'pi pi-fw pi-file',
            items: [
                {label: 'Empty Page', icon: 'pi pi-fw pi-circle-off', to: '/empty'}
            ]
        },
        {
            label: 'Menu Hierarchy', icon: 'pi pi-fw pi-search',
            items: [
                {
                    label: 'Submenu 1', icon: 'pi pi-fw pi-bookmark',
                    items: [
                        {
                            label: 'Submenu 1.1', icon: 'pi pi-fw pi-bookmark',
                            items: [
                                {label: 'Submenu 1.1.1', icon: 'pi pi-fw pi-bookmark'},
                                {label: 'Submenu 1.1.2', icon: 'pi pi-fw pi-bookmark'},
                                {label: 'Submenu 1.1.3', icon: 'pi pi-fw pi-bookmark'},
                            ]
                        },
                        {
                            label: 'Submenu 1.2', icon: 'pi pi-fw pi-bookmark',
                            items: [
                                {label: 'Submenu 1.2.1', icon: 'pi pi-fw pi-bookmark'},
                                {label: 'Submenu 1.2.2', icon: 'pi pi-fw pi-bookmark'}
                            ]
                        },
                    ]
                },
                {
                    label: 'Submenu 2', icon: 'pi pi-fw pi-bookmark',
                    items: [
                        {
                            label: 'Submenu 2.1', icon: 'pi pi-fw pi-bookmark',
                            items: [
                                {label: 'Submenu 2.1.1', icon: 'pi pi-fw pi-bookmark'},
                                {label: 'Submenu 2.1.2', icon: 'pi pi-fw pi-bookmark'},
                                {label: 'Submenu 2.1.3', icon: 'pi pi-fw pi-bookmark'},
                            ]
                        },
                        {
                            label: 'Submenu 2.2', icon: 'pi pi-fw pi-bookmark',
                            items: [
                                {label: 'Submenu 2.2.1', icon: 'pi pi-fw pi-bookmark'},
                                {label: 'Submenu 2.2.2', icon: 'pi pi-fw pi-bookmark'}
                            ]
                        }
                    ]
                }
            ]
        },
        {label: 'Documentation', icon: 'pi pi-fw pi-question', command: () => {window.location = "#/documentation"}},
        {label: 'View Source', icon: 'pi pi-fw pi-search', command: () => {window.location = "https://github.com/primefaces/sigma-vue"}}
    ]*/
}  