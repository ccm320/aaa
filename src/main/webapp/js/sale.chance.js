function formatterState(val) {
    if (val==0){
        return "未分配";
    }else if(val==1){
        return "已分配";
    }else {
        return "未定义";
    }
}
$(function () {
    searchSaleChances();
})
//查询方法
function searchSaleChances() {
    $("#dg").datagrid("load",{
        createMan:$("#createMan").val(),
        customerName:$("#customerName").val(),
        createDate:$("#createDate").datebox("getValue"),
        state:$("#state").combobox("getValue")
    })
}

function openAddAccountDialog() {
    $("#dlg").dialog("open");

}
function closeDialog() {
    $("#dlg").dialog("close");
}

function saveAccount() {
    $("#fm").form("submit",{
        url:ctx+"/sale_chance/insert",
        onSubmit:function (params) {
            params.createMan=$.cookie("trueName");
            return $("#fm").form("validate");
        },
        success:function (data) {
            data=JSON.parse(data);
            if (data.code==200){
                $.messager.alert("来自Crm项目",data.msg,"info");
                closeDialog();
                searchSaleChances();
            }else {
                $.messager.alert("来自Crm项目",data.msg,"error");
            }
        }
    })
}