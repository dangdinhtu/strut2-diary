<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
    Document   : Sigma Grid
    Created on : Jun 11, 2011, 11:08:36 AM
    Author1     : Vũ Duy Bình
    Author2     : Phan Đức Dũng
--%>

<%@tag description="Bảng dữ liệu" pageEncoding="UTF-8"%>

<%@attribute name="gridId" required="true" %>
<%@attribute name="loadURL" description="Đường link để tải dữ liệu"%>
<%@attribute name="jsonParamName" description="Dùng thiết lập thông tin của lưới master/detail"%>
<%@attribute name="saveURL" description="Đường link để lưu dữ liệu inline"%>
<%@attribute name="fieldColumns" %>
<%@attribute name="containerId" required="true" description="Cần khai báo trước khi khai báo grid"%>
<%@attribute name="autoLoad" description="Có tự động load khi khai báo không"%>
<%@attribute name="width" %>
<%@attribute name="height" %>
<%@attribute name="uniqueField" %>
<%@attribute name="defaultRecord" description="Giá trị mặc định của cell"%>
<%@attribute name="showGridMenu" %>
<%@attribute name="selectRowByCheck" %>
<%@attribute name="toolbarContent" %>
<%@attribute name="pageSize" %>
<%@attribute name="clickStartEdit" %>
<%@attribute name="afterSave" %>
<%@attribute name="onCellClick" %>
<%@attribute name="pageSizeList" %>
<%@attribute name="remotePaging" %>
<%@attribute name="remoteSort" %>
<%@attribute name="afterEdit" %>
<%@attribute name="beforeEdit" %>
<%@attribute name="customHeader" %>
<%@attribute name="onMouseOver" %>
<%@attribute name="onMouseOut" %>

<%
    if (width == null || "".equals(width.toString())) {
        width = "100%";
    }
    if (height == null || "".equals(height.toString())) {
        height = "400";
    }
    if (showGridMenu == null || "".equals(showGridMenu.toString())) {
        showGridMenu = "true";
    }
    if (selectRowByCheck == null || "".equals(selectRowByCheck.toString())) {
        selectRowByCheck = "true";
    }
    if (toolbarContent == null || "".equals(toolbarContent.toString())) {
        toolbarContent = "nav | pagesize | goto | state";
    }
    if (pageSize == null || "".equals(pageSize.toString())) {
        pageSize = "10";
    }
    if (clickStartEdit == null || "".equals(clickStartEdit.toString())) {
        clickStartEdit = "false";
    }
    if (pageSizeList == null || "".equals(pageSizeList.toString())) {
        pageSizeList = "[10,15,20,25,30,50,100,200]";
    }
    if (remotePaging == null || "".equals(remotePaging.toString())) {
        remotePaging = "true";
    }
    if (remoteSort == null || "".equals(remoteSort.toString())) {
        remoteSort = "true";
    }
    if (autoLoad == null || "".equals(autoLoad.toString())) {
        autoLoad = "true";
    }
    
    if (customHeader == null || "".equals(customHeader.toString())) {
        customHeader = "";
    }
    
    if (jsonParamName == null || "".equals(jsonParamName.toString())) {
        jsonParamName = "_gt_json";
    }

    // Xu ly cac truong hop dac biet, khong the de rong
    if (onCellClick != null && !"".equals(onCellClick.toString())) {
        onCellClick = "onCellClick: " + onCellClick + ",";
    } else {
        onCellClick = "";
    }
    if (afterSave != null && !"".equals(afterSave.toString())) {
        afterSave = "afterSave: " + afterSave + ",";
    } else {
        afterSave = "";
    }
    if (onMouseOver != null && !"".equals(onMouseOver.toString())) {
        onMouseOver = "onMouseOver: " + onMouseOver + ",";
    } else {
        onMouseOver = "";
    }
    if (onMouseOut != null && !"".equals(onMouseOut.toString())) {
        onMouseOut = "onMouseOut: " + onMouseOut + ",";
    } else {
        onMouseOut = "";
    }
    if (afterEdit != null && !"".equals(afterEdit.toString())) {
        afterEdit = "afterEdit: " + afterEdit + ",";
    } else {
        afterEdit = "";
    }
    if (beforeEdit != null && !"".equals(beforeEdit.toString())) {
        beforeEdit = "beforeEdit: " + beforeEdit + ",";
    } else {
        beforeEdit = "";
    }
%>

<script type="text/javascript">
    $(function() {
        try {
        var mygrid = new Sigma.Grid( {
            id: "<%=gridId%>",
            jsonParamName: "<%=jsonParamName%>",
            loadURL: '${contextPath}' + '<%=loadURL%>',
            saveURL: '${contextPath}' + '<%=saveURL%>',
            width: "<%=width%>",
            height: "<%=height%>",
            container: '<%=containerId%>',
            showGridMenu: <%=showGridMenu%>,
            selectRowByCheck: <%=selectRowByCheck%>,
            selectRowWhenClick:true,
            toolbarContent : '<%=toolbarContent%>',
            pageSize: <%=pageSize%>,
            clickStartEdit: <%=clickStartEdit%>,
            dataset: { fields: [ <%=fieldColumns%> ], uniqueField: '<%=uniqueField%>' },
            pageSizeList: [10,15,20,25,30,50,100,200], //pageSizeList
            remotePaging: <%=remotePaging%>,
            remoteSort: <%=remoteSort%>,
            <%if (customHeader != null && !"".equals(customHeader.toString())) {%>
                customHead: '<%=customHeader %>',
            <%}%>
            
            columns: [ <jsp:doBody/> ],
            <%=onCellClick%>
            <%=afterSave%>
            <%=afterEdit%>
            <%=beforeEdit%>
            toolbarPosition: 'bottom',
            allowFreeze: false,
            allowHide: false,
            allowGroup: false,
            allowCustomSkin: false,
            resizable: false,
            filterable: true,
            recountAfterSave: true,
            showIndexColumn: true,
            skin: "default",
            encoding: 'UTF-8',
            <%=onMouseOut%>
            <%=onMouseOver%>
            defaultRecord: { ${defaultRecord} },
        } );

        <%if ("true".equals(autoLoad)) { %>mygrid.render()<% }%>
        } catch (ex) {
            alert(ex.message);
            alert(mygrid);
        }
    });
</script>
