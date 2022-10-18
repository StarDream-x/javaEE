var vue=new Vue({
    el: '#app',
    data:{
        keyword:"",
        goods: [], //查询结果
        currentGoods:{}, //当前编辑的事项
        dialogVisible: false, //对话框是否显示
        editMode:false  //当前是否是编辑模式（还是添加模式）
    },
    methods: {
        query: function (keyword) {
            var path='/goods';
            if(this.keyword!="") path=path+"?name="+this.keyword;
            var self = this
            axios.get(path)
                .then(response=> {
                    self.goods = response.data
                })
                .catch(e =>self.$message.error(e.response.data))
        },
        deleteGoods: function (goods) {
            var self = this
            axios.delete('/goods/'+goods.id)
                .then(response=> {
                    self.query()
                })
                .catch(e =>self.$message.error(e.response.data))
        },
        showEdit:function(goods){
            this.dialogVisible = true
            this.editMode=true;
            this.currentGoods = Object.assign({},goods)
        },
        showAdd:function(goods){
            this.dialogVisible = true
            this.editMode=false;
            this.currentGoods = {complete:false}
        },
        saveGoods:function(){
            var self = this
            if(self.editMode){
                axios.put('/goods/'+self.currentGoods.id,self.currentGoods)
                    .then(response=> self.query())
                    .catch(e =>self.$message.error(e.response.data))
            }else{
                axios.post('/goods',self.currentGoods)
                    .then(response=> self.query())
                    .catch(e => self.$message.error(e.response.data))
            }
            this.dialogVisible = false
        }
    }
})
vue.query();