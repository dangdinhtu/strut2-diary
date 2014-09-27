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
                            <p>Giới thiệu về hệ thống nhật kí</p>
                        </div>
                        <div class="bk-content">
                            <p>Giới thiệu về hệ thống nhật kí</p>
                        </div>
                        <div class="bk-content">
                            <p>Hướng dẫn cách viết nhật kí</p>
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
        <c:forEach var="item" items="${lstDiaryBook}">
            <li>
                <div class="bk-book book-3 bk-bookdefault">
                    <div class="bk-front">
                        <div class="bk-cover">
                            <h2>
                                <span>J.C. Salinger</span>
                                <span>Ngon</span>
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
                            <span>J.C. Salinger</span>
                            <span>The Catcher in the Rye</span>
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
                    <a href="diary?action=write-diary&dbkId=${item.dbkId}" class="btn btn-default">Viết nhật kí</a>
                </div>
            </li>
        </c:forEach>
            <li>
                <div class="bk-book book-2 bk-bookdefault">
                    <div class="bk-front">
                        <div class="bk-cover">
                            <h2>
                                <span>The Catfather</span>
                                <span>Mario Purrzo</span>
                            </h2>
                        </div>
                        <div class="bk-cover-back"></div>
                    </div>
                    <div class="bk-page">
                        <div class="bk-content">
                            <p>Whale catfish leatherjacket deep sea anglerfish grenadier sawfish pompano dolphinfish carp large-eye bream, squeaker amago. Sandroller; rough scad, tiger shovelnose catfish snubnose parasitic eel? Black bass soldierfish duckbill--Rattail Atlantic saury Blind shark California halibut; false trevally warty angler!</p>
                        </div>
                        <div class="bk-content">
                            <p>Trahira giant wels cutlassfish snapper koi blackchin mummichog mustard eel rock bass whiff murray cod. Bigmouth buffalo ling cod giant wels, sauger pink salmon. Clingfish luderick treefish flatfish Cherubfish oldwife Indian mul gizzard shad hagfish zebra danio. Butterfly ray lizardfish ponyfish muskellunge Long-finned sand diver mullet swordfish limia ghost carp filefish.</p>
                        </div>
                        <div class="bk-content bk-content-current">
                            <p>Red snapper Kafue pike fangtooth humums's slipmouth, salmon cutlassfish; swallower European perch mola mola sunfish, threadfin bream. Billfish hog sucker trout-perch lenok orbicular velvetfish. Delta smelt striped bass, medusafish dragon goby starry flounder cuchia round whitefish northern anchovy spadefish merluccid hake cat shark Black pickerel. Pacific cod.</p>
                        </div>
                    </div>
                    <div class="bk-back">
                        <p>Tyrant, blackmailer, racketeer, murderer - his influence reaches every level of American society. Meet Cat Corleone, a friendly cat, a just cat, a reasonable cat. The deadliest lord of the Cata Nostra. The Catfather.</p>
                    </div>
                    <div class="bk-right"></div>
                    <div class="bk-left">
                        <h2>
                            <span>The Catfather</span>
                            <span>by Mario Purrzo</span>
                        </h2>
                    </div>
                    <div class="bk-top"></div>
                    <div class="bk-bottom"></div>
                </div>
                <div class="bk-info">
                    <button class="bk-bookback">Flip</button>
                    <button class="bk-bookview">View inside</button>
                </div>
            </li>
            <li>
                <div class="bk-book book-3 bk-bookdefault">
                    <div class="bk-front">
                        <div class="bk-cover">
                            <h2>
                                <span>J.C. Salinger</span>
                                <span>The Catcher in the Rye</span>
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
                            <span>J.C. Salinger</span>
                            <span>The Catcher in the Rye</span>
                        </h2>
                    </div>
                    <div class="bk-top"></div>
                    <div class="bk-bottom"></div>
                </div>
                <div class="bk-info">
                    <button class="bk-bookback">Flip</button>
                    <button class="bk-bookview">View inside</button>
                </div>
            </li>
        </ul>
    </div>

</div>