
<!DOCTYPE HTML>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
    <title>CSS3 3D Transforms - 3D Page Turning Book Experiment</title>
    <link href="${contextPath}/layout/frontend/css/read-content.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/layout/frontend/css/read-book.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/layout/frontend/css/read-mobile.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700' rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=yes" />


<div id="book-wrapper" class="notthreed">
    <div id="book">
        <ul>

            <li class="page currentpage">
                <ul>
                    <li class="left">
                    </li>
                    <li class="right front-cover">
                        <div>
                            <h4>Book Rendered in 3D Transform CSS</h4>
                            <h5>Except it isn't at the moment! <br />
                                Press the button up there for that.</h5>
                            <p>But there is a story from page 7 onwards</p>
                            <h6>Read on...</h6>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <h1>CSS3 3D Transforms</h1>
                            <h2>3D Page Turning Book Experiment</h2>
                            <p>Once apon a time, a long, long time ago, there was a big bad monster called Flash... </p>
                            <p>Then one day Ben, a web designer from London, thought to himself maybe it just might be possible to create a book with turning pages, like they used to try and replicate in Flash, but using CSS3 3D Transforms.</p>
                            <p>An actual 3D book that Search engines would love because all the content is laid out in a neat and semantic way!</p>

                            <h1>CSS3 3D Transforms</h1>
                            <h2>3D Page Turning Book Experiment</h2>
                            <p>Once apon a time, a long, long time ago, there was a big bad monster called Flash... </p>
                            <p>Then one day Ben, a web designer from London, thought to himself maybe it just might be possible to create a book with turning pages, like they used to try and replicate in Flash, but using CSS3 3D Transforms.</p>
                            <p>An actual 3D book that Search engines would love because all the content is laid out in a neat and semantic way!</p>

                            <h1>CSS3 3D Transforms</h1>
                            <h2>3D Page Turning Book Experiment</h2>
                            <p>Once apon a time, a long, long time ago, there was a big bad monster called Flash... </p>
                            <p>Then one day Ben, a web designer from London, thought to himself maybe it just might be possible to create a book with turning pages, like they used to try and replicate in Flash, but using CSS3 3D Transforms.</p>
                            <p>An actual 3D book that Search engines would love because all the content is laid out in a neat and semantic way!</p>

                            <h1>CSS3 3D Transforms</h1>
                            <h2>3D Page Turning Book Experiment</h2>
                            <p>Once apon a time, a long, long time ago, there was a big bad monster called Flash... </p>
                            <p>Then one day Ben, a web designer from London, thought to himself maybe it just might be possible to create a book with turning pages, like they used to try and replicate in Flash, but using CSS3 3D Transforms.</p>
                            <p>An actual 3D book that Search engines would love because all the content is laid out in a neat and semantic way!</p>
                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <h3>An actual 3D, fully functional, book!</h3>
                            <p>Not only that but the pages would actually turn, not just look as though they do.</p>
                            <p>Everyone thought Ben was mad but he set to work anyway...</p>
                            <p>Low and behold, after a couple of evenings work he eventually reemerges with this monstrosity!</p>
                            <p>Unfortunately this with never work with Flash's evil friends the Internet Explorer family, neither will it work on older graphics cards, but for now, Ben is content with his creation.</p>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p>Page Three</p>
                            <p>As it is simply created using basic HTML there is no problem in adding images or links etc.</p>
                            <p>At the moment it is completely responsive including the font size. So it should work in any size window... In theory.</p>
                            <p>Yes it does still have a few glitches here and there but this is only a beta testing version so all will hopefully come good in the end.</p>
                            <p>One day I hope to have it fully functional on tablets so you can flip the page with a swipe of your finger.</p>
                            <p>To be continued...</p>
                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <p>Page Four</p>
                            <p class="now-with floatleft">Now with Mobile Mode!</p>
                            <p>Although only the bottom navigational buttons work at the moment.</p>
                            <p>Narrow your browser to a portrait ratio for it to come into effect.</p>
                            <p>Not available in 3d :(</p>
                            <p class="now-with also floatright">Now also available with arrow keys!</p>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p id="pagefive">Page Five</p>
                            <a href="http://www.tinydesign.co.uk/ben-evans-portfolio/" target="_blank" title="A link on the left">A link on the left.</a>
                            <a href="http://www.tinydesign.co.uk/ben-evans-portfolio/" target="_blank" title="Another link on the left but this time it's an image"><img alt="Jack the Ripper" src="http://www.tinydesign.co.uk/css3-3d-transforms-book/images/jacktherippersm.jpg" /></a>

                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <p id="pagesix">Page Six</p>
                            <a href="http://www.tinydesign.co.uk/ben-evans-portfolio/" target="_blank" title="A link on the right">A link on the right.</a>
                            <a href="http://www.tinydesign.co.uk/ben-evans-portfolio/" target="_blank" title="Another link on the right"><img alt="St Catherine Hill" src="http://www.tinydesign.co.uk/css3-3d-transforms-book/images/stcatherines-hill-guildfsm.jpg" /></a>

                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p>Page Seven</p>
                            <img class="floatright image" alt="Deman Drawkcab" src="http://www.tinydesign.co.uk/css3-3d-transforms-book/images/Deman.png" /> 
                            <p>
                                Deman Drawkcab is not your average cup of tea. Slightly different to thee established Homo-sapiens. Not utterly different but by no means run-of-the-mill.
                            </p>
                            <p>
                                For example: Yesterday Deman had just crossed Green Park and was now walking up Picadilly in London. He stopped just outside the Ritz on his way to the Police station. I should point out, he wasn't going there to help out, he was in trouble, but I'll get to that later... Anyway, he was outside the Ritz waiting to cross the road; the traffic lights to his right had obviously turned red as the oncoming traffic had stopped so he began to cross. 
                            </p>


                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <p>Page Eight</p>
                            <p>
                                Now the thing about these lights outside the Ritz is, they have a pedestrian crossing marked on the road, but, there are no nice green men available to suggest when for him to cross. Deman presumed it was good to go as the traffic to his right had stopped and he only needed to make it to the central road gondola, as if that's what it's called, but unfortunately the traffic had only stopped to let the other traffic from the junction in front on him out. This traffic roared from the junction, eager to get where they need to be. It was too late for Deman to turn back now, he was half way across yet a white van in the inside lane accelerated towards him fast....
                            </p>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p>Page Nine</p>
                            <img class="floatright image" alt="Deman Drawkcab" src="http://www.tinydesign.co.uk/css3-3d-transforms-book/images/deman-drawkcab.jpg" />
                            <p>Sorry to stop at this rather inconvenient moment but I think I may have to fill you in with a few details. Deman Drawkcab is an odd looking man. He is tall, well built but not visibly muscular, a large build, but not fat. He has a strange geeky, mullet type hair cut which looks as if it was styled in the 70's and gives him the appearance of being a bit simple and slow, like a man you wouldn't want to sit next to on the bus for fear you have no idea what he might do next. A bit like a retarded tramp. I think an inbred appearance might be the best way to describe him. </p>
                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <p>Page Ten</p>
                            <p>Deman is very antisocial, he has no friends and only really talks in grunts, mainly due to laziness, he could probably hold a meaningful conversation but anyone is yet to find out. His appearance is deceptive, not in the way you might think, for he is incredibly unfit and very easily gets out of breath, merely walking causes him suitable discomfort.</p>
                            <p>He knows he is different, his parents were similar. He has noticed that with every generation the Drawkcab's were getting more and more different from the last, further from the norm, different in quite an extraordinary way. Their build has become slightly bulkier than an average person with every birth, but that's pretty insignificant, the strange thing is that their appearance doesn't really reflect their actual weight.
                            </p>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p>Page Eleven</p>
                            <p>
                                Unfortunately Deman has not been able to find any scales strong enough to way himself which gives you a clue to his unconventional characteristic. His mum being the curious type, a tall, voluptuous lady, but not fat, once had access to a weigh bridge and found she weighed a mere 9120 kg, around 10 tons or 1436 stone, depending on how you work.
                            </p>
                            <p>Deman is guessing that he is double this, going by the effect he has on the surrounding landscape and knowing that his mum was double the weight of his grandmother.

                        </div>
                    </li>
                    <li class="right">
                        <div>
                            <p>Page Twelve</p>
                            <p>
                                Being the same weight as a double-decker bus has it's disadvantages; not being able to enjoy a nice day at the beach or a long walk in the park, not being able to enter most shops or buildings for fear that the floor will collapse, not being able to cross many small bridges, drive, ride public transport or catch aeroplanes. But it does have a fair number of advantages. Everything is relative and having all that mass compressed into such a small frame does enable him to lift things easily half his weight, such as a car, making changing a tyre a doddle, not that he needs to do this very often. Also with this great bulk, compared to an average man he appears to be made of iron or in his case lead and fairly indestructible when he comes in contact with things that an average man would ever encounter on a day to day basis.
                            </p>
                        </div>
                    </li>
                </ul>
            </li>

            <li class="page nextpage">
                <ul>
                    <li class="left">
                        <div>
                            <p>Page Thirteen</p>
                            <p>Things to do...</p>
                            <ul>
                                <li>Add arrow keys function &#10004;</li>
                                <li>Fix left page zoom in explode mode &#10004;</li>
                                <li>Improve animation in Explorer &#10004;</li>
                                <li>Swipe on mobile &#10004;</li>
                                <li>3D Button - Active / Inactive &#10004;</li>
                                <li>Sort out Zoom &#10004;</li>
                                <li>Fix explode in mobile &#10004;</li>
                                <li>Fix lists in zoom mode &#10004;</li>
                                <li>Fix images in Explorer</li>
                                <li>Fix mobile to full</li>
                                <li>Improve swipe on mobile</li>
                                <li>Improve speed</li>
                            </ul>
                        </div>
                    </li>
                    <li class="right">
                        <div></div>
                    </li>
                </ul>
            </li>

        </ul>

        <a href="" title="< Previous" id="previous">&lt;</a>
        <a href="" title="Next >" id="next">&gt;</a>
    </div>
    <ul id="booktopbar">
        <li id="explode">
            <a href="" title="Explode"><b></b><b></b><b></b><b></b> Explode</a>
        </li>
        <li id="unexplode">
            <a href="" title="Explode"><b></b><b></b> Un-Explode</a>
        </li>
        <li id="booknav">
            <a id="navfirst" href="" title="First">&Iota;&lt;</a>
            <a id="navback" class="move" href="" title="Previous">&lt;</a>
            <a id="mobback" class="move" href="" title="Previous">&lt;</a>
            <p></p>
            <a id="navforward" class="move" href="" title="Next">&gt;</a>
            <a id="mobforward" class="move" href="" title="Next">&gt;</a>
            <a id="navlast" href="" title="Last">&gt;&Iota;</a>
        </li>
        <li id="threedoverride">
            <a class="notthreedeed" href="#" title="3D Over Ride Switch"><b></b> 3D</a>
        </li>
    </ul>
    <ul id="bookpagezoomwrapper">
        <li id="bookpagezoom">
            <a id="bookzoomclose" href="#" title="Close">X</a>
            <div></div>
            <!--<a href="" title="< Previous" id="zoomprevious">&lt;</a>
            <a href="" title="Next >" id="zoomnext">&gt;</a>-->
        </li>
    </ul>
    <div id="pright">
        <a href="http://www.benevansdesign.co.uk" title="&copy; Ben Evans 2012">&copy; Ben Evans 2012</a>
    </div>
    <audio id="audio1" preload="auto">
        <source src="audio/page-flip-1b.mp3" type="audio/mpeg" />
        <source src="audio/page-flip-1b.ogg" type="audio/ogg" />
    </audio>
    <audio id="audio2" preload="auto">
        <source src="audio/flick-through-2b.mp3" type="audio/mpeg" />
        <source src="audio/flick-through-2b.ogg" type="audio/ogg" />
    </audio>
    <audio id="audio3" preload="auto">
        <source src="audio/paper-rip-1b.mp3" type="audio/mpeg" />
        <source src="audio/paper-rip-1b.ogg" type="audio/ogg" />
    </audio>
    <audio id="audio4" preload="auto">
        <source src="audio/3d.mp3" type="audio/mpeg" />
        <source src="audio/3d.ogg" type="audio/ogg" />
    </audio>

</div>
<div id="bodyshadow"></div>
<script src="${contextPath}/layout/frontend/js/read-ga.js" type="text/javascript" async="" ></script>
<script src="${contextPath}/layout/frontend/js/lib/jquery-1.8.js" type="text/javascript"></script>
<script src="${contextPath}/layout/frontend/js/read-js.js" type="text/javascript"></script>
<script src="${contextPath}/layout/frontend/js/read-3d.js" type="text/javascript"></script>
<script src="${contextPath}/layout/frontend/js/read-mobile.js" type="text/javascript"></script>
<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-4415130-7']);
    _gaq.push(['_trackPageview']);
    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();
</script>