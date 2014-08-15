<%-- 
    Document   : sigmaGridColumn
    Created on : Jun 11, 2011, 10:34:43 AM
    Author     : Vu Duy Binh
--%>

<%@tag description="Các cột trong lưới" pageEncoding="UTF-8"%>

<%@attribute name="id" required="true"%>
<%@attribute name="headerText"%>
<%@attribute name="headAlign"%>
<%@attribute name="align"%>
<%@attribute name="isCheckColumn"%>
<%@attribute name="editable"%>
<%@attribute name="sortable"%>
<%@attribute name="width"%>
<%@attribute name="renderer"%>
<%@attribute name="editor"%>
<%@attribute name="grouped"%>
<%@attribute name="toolTip"%>
<%@attribute name="toolTipWidth"%>
<%@attribute name="toolTipHeight"%>

<%
    //Trường hợp là cột checkbox, nhãn thế nào thì nó thế
    if (headerText == null || "".equals(headerText)) {
        headerText = "''";
    } else if(!"true".equals(isCheckColumn)){
        headerText = com.tig.nbt.common.CommonUtils.getApplicationResource(headerText);
    }
    
    if (headAlign == null || "".equals(headAlign)) {
        headAlign = "left";
    }
    if (align == null || "".equals(align)) {
        align = "left";
    }
    if (width == null || "".equals(width)) {
        width = "''";
    }
    if (isCheckColumn == null || "".equals(isCheckColumn)) {
        isCheckColumn = "true";
    }
    if (editable == null || "".equals(editable)) {
        editable = "false";
    }
    if (sortable == null || "".equals(sortable)) {
        sortable = "true";
    }
    if (editor == null || "".equals(editor)) {
        editor = "\"\"";
    }
    if (grouped == null || "".equals(grouped)) {
        grouped = "false";
    }
    if (toolTip == null || "".equals(toolTip)) {
        toolTip = "false";
    }
    if (toolTipWidth == null || "".equals(toolTipWidth)) {
        toolTipWidth = "200";
    }
    if (toolTipHeight == null || "".equals(toolTipHeight)) {
        toolTipHeight = "300";
    }
%>

<%
    if (id == "chk") {
%>

{id: '<%=id%>' , isCheckColumn : <%=isCheckColumn%> , headAlign : "<%=headAlign%>", align : "<%=align%>", editable: <%=editable%> },

<%
} else if (renderer != null && !"".equals(renderer.trim())) {
%>

{id: '<%=id%>' , header: "<%=headerText%>" , width: <%=width%>,  headAlign : "<%=headAlign%>", align : "<%=align%>", editable: <%=editable%>, editor : <%=editor%>, sortable : <%=sortable%>, grouped : <%=grouped%> , renderer : <%=renderer%>, toolTip : <%=toolTip%>, toolTipWidth : <%=toolTipWidth%>, toolTipHeight : <%=toolTipHeight%> },

<%
} else {
%>

{id: '<%=id%>' , header: "<%=headerText%>" , width: <%=width%>,  headAlign : "<%=headAlign%>", align : "<%=align%>", editable: <%=editable%>, editor : <%=editor%>, sortable : <%=sortable%> , grouped : <%=grouped%>,  toolTip : <%=toolTip%>, toolTipWidth : <%=toolTipWidth%>, toolTipHeight : <%=toolTipHeight%> },

<%
}
%>
