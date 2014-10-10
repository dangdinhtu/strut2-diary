<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<div class="col-md-10 col-xs-12 col-md-offset-1">
    <div class="main">
        <ul id="bk-list" class="bk-list clearfix">
            <li>
                <div class="bk-book book-1 bk-bookdefault">
                    <div class="bk-front">
                        <div class="bk-cover">
                            <h2>
                                <span>Tiêu đề quyển nhật kí</span>
                                <span>Tên nhật kí</span>
                            </h2>
                        </div>
                        <div class="bk-cover-back"></div>
                    </div>
                    <div class="bk-page">
                        <div class="bk-content bk-content-current">
                            <p>Viết để biết được kinh nghiệm trưởng thành của bản thân. Viết để lưu lại và chia sẽ với con cái, bạn bè và những người đời sau, để họ biết được tôi đã làm như thế nào khắt phục nỗi sợ hãi, làm thế nào để thoát khỏi bế tắc, làm thế nào để nhận định mục tiêu.
                            </p>
                        </div>
                        <div class="bk-content">
                            <p>Giây phút bạn ghi lại những điều tâm đắc thì tư tưởng của các bạn chỉ tập trung vào việc ấy, việc viết nhật ký sẽ giúp các bạn bồi dưỡng sự tập trung chú ý. Viết nhật ký cũng có tác dụng cách ly, nếu chúng ta đã ghi vấn đề trên giấy trắng là đã cách ly được cảm giác trong lòng, do vậy vấn đề cảm thấy nghiêm trọng ở trong đầu óc sẽ trở nên không còn nghiêm trọng đến mức như vậy nữa…
                            </p>
                        </div>
                        <div class="bk-content">
                            <p>Giây phút bạn ghi lại những điều tâm đắc thì tư tưởng của các bạn chỉ tập trung vào việc ấy, việc viết nhật ký sẽ giúp các bạn bồi dưỡng sự tập trung chú ý. Viết nhật ký cũng có tác dụng cách ly, nếu chúng ta đã ghi vấn đề trên giấy trắng là đã cách ly được cảm giác trong lòng, do vậy vấn đề cảm thấy nghiêm trọng ở trong đầu óc sẽ trở nên không còn nghiêm trọng đến mức như vậy nữa…
                            </p>
                        </div>
                    </div>
                    <div class="bk-back">
                        <p>Nội dung bìa sau</p>
                    </div>
                    <div class="bk-right"></div>
                    <div class="bk-left">
                        <h2>
                            <span>Nhật kí tình yêu</span>
                            <span>Diary</span>
                        </h2>
                    </div>
                    <div class="bk-top"></div>
                    <div class="bk-bottom"></div>
                </div>
                <div class="bk-info">
                    <a class="bk-bookback btn btn-default">Bìa sau</a>
                    <a class="bk-bookview btn btn-default">Mô tả</a>
                    <!--                    <button class="demo-popup">Chia sẻ</button>-->
                    <a href="diary?action=read" class="btn btn-default">Đọc nhật kí</a>
                    <a href="#" class="btn btn-default">Viết nhật kí</a>
                </div>
            </li>
        <c:forEach var="item" items="${beanDiaryBook}">
            <style>
                .book-3 .bk-front > div,
                .book-3 .bk-back,
                .book-3 .bk-left,
                .book-3 .bk-front:after {
                        background-color: ${item.backgroundAudio}!important;
                }
                
            </style>
                
            <li>
                <div class="bk-book book-3 bk-bookdefault">
                    <div class="bk-front" style="background-color: red !important;">
                        <div class="bk-cover">
                            <h2>
                                <span>${item.dateCreate} </span>
                                <span>${item.name}</span>
                            </h2>
                        </div>
                        <div class="bk-cover-back"></div>
                    </div>
                    <div class="bk-page">
                        <div class="bk-content bk-content-current">
                            <p>Oceanic flyingfish spotted danio fingerfish leaffish, Billfish halibut Atlantic cod threadsail poacher slender mola. Swallower muskellunge, turbot needlefish yellow perch trout dhufish dwarf gourami false moray southern smelt cod dwarf gourami. Betta blue catfish bottlenose electric ray sablefish.</p>
                        </div>
                        <div class="bk-content">
                            <p>Whale catfish leatherjacket deep sea anglerfish grenadier sawfish pompano dolphinfish carp large-eye bream, squeaker amago. Sandroller; rough scad, tiger shovelnose catfish snubnose parasitic eel? Black bass soldierfish duckbill--Rattail Atlantic saury Blind shark California halibut; false trevally warty angler!</p>
                        </div>
                        <div class="bk-content">
                            <p>Trahira giant wels cutlassfish snapper koi blackchin mummichog mustard eel rock bass whiff murray cod. Bigmouth buffalo ling cod giant wels, sauger pink salmon. Clingfish luderick treefish flatfish Cherubfish oldwife Indian mul gizzard shad hagfish zebra danio. Butterfly ray lizardfish ponyfish muskellunge Long-finned sand diver mullet swordfish limia ghost carp filefish.</p>
                        </div>
                    </div>
                    <div class="bk-back">
                        <img src="images/3.png" alt="cat"/>
                        <p>Holden Catfield is a seventeen-year-old dropout who has just been kicked out of his fourth school. Navigating his way through the challenges of growing up, Holden dissects the 'phony' aspects of society.</p>
                    </div>
                    <div class="bk-right"></div>
                    <div class="bk-left">
                        <h2>
                            <span>${item.dateCreate}</span>
                            <span>${item.name}</span>
                        </h2>
                    </div>
                    <div class="bk-top"></div>
                    <div class="bk-bottom"></div>
                </div>
                <div class="bk-info">
                    <a class="bk-bookback btn btn-default">Bìa sau</a>
                    <a class="bk-bookview btn btn-default">Mô tả</a>
                    <!--                    <button class="demo-popup">Chia sẻ</button>-->
                    <a href="diary?action=read&id=${item.dbkId}" class="btn btn-default">Đọc nhật kí</a>
                    <a href="diary?action=write-diary&id=${item.dbkId}" class="btn btn-default">Viết nhật kí</a>
                </div>
            </li>
        </c:forEach>
        </ul>
    </div>

</div>