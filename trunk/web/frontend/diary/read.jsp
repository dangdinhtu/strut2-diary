
<%@page import="java.util.Date"%>
<%@page import="diary.dao.DiaryBookDAO"%>
<%@page import="diarry.bean.BeanDiaryBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<ul>
    <li class="page currentpage">
        <ul>
            <li class="left">
            </li>
            <li class="right front-cover">
                <div>
                    <h4>Tên cuốn nhật kí</h4>
                    <h5>Title của nhật kí <br />
                        Nhấn nút next để đọc nhật kí</h5>
                    <p>But there is a story from page 7 onwards</p>
                    <h6>Read on...</h6>
                </div>
            </li>
        </ul>
    </li>
    <%
        DiaryBookDAO diaryBookDAO = new DiaryBookDAO();
        int userId = 125;
            int dbkId = 1;
            List<Object> lstDiaryBookContent = diaryBookDAO.getDiaryBookContent(userId, dbkId);
            List<BeanDiaryBook> lst = new ArrayList<BeanDiaryBook>();
            for (int i=0; i<lstDiaryBookContent.size(); i++){
                Object[] row = (Object[]) lstDiaryBookContent.get(i);
                BeanDiaryBook obj = new BeanDiaryBook();
                obj.setUserId((Integer) row[0]);
                obj.setDbkId((Integer) row[1]);
                obj.setTitle((String) row[2]);
                obj.setContent((String) row[3]);
                obj.setDateWritten((Date) row[4]);
                lst.add(obj);
            }
        int i = 0;
        for(i = 0; i < lst.size(); i = i+2){
            BeanDiaryBook beanDiaryBookEvent = lst.get(i);
            BeanDiaryBook beanDiaryBookOdd = null;
            if(lst.size() > 1){
                beanDiaryBookOdd = lst.get(i+1);
            }
            
            
            
    %>
            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p style="text-align: center;"><%=(i+1)%></p>
                            <h1><% out.print(beanDiaryBookEvent.getTitle()); %></h1>
                            <p><% out.print(beanDiaryBookEvent.getContent()); %> </p>
                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <p style="text-align: center;"><%=(i+2)%></p>
                            <h3><% //out.print(beanDiaryBookOdd.getTitle()); %></h3>
                            <p><% //out.print(beanDiaryBookOdd.getContent()); %> </p>
                        </div>
                    </li>
                </ul>
            </li>
    <%        
        }
    %>

    <li class="page nextpage">
        <ul>
            <li class="left">
                <div>
                    <h3>Mục lục</h3>
                    <ul>
                        <c:forEach items="${lstDiaryBookContent}" var="item" varStatus="index">
                            <li><span style="width: 60%">${item.title}</span> <span style="margin-left: 20px">${index.count}</span></li>
                        </c:forEach>
                    </ul>
                </div>
            </li>
            <li class="right">
                <div></div>
            </li>
        </ul>
    </li>
</ul>



