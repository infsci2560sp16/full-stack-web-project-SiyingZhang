<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <#include "header.ftl">
        <style>
            *{
                margin:0;
                padding:0;
            }
            body{
                font-family:Arial;
                background:#fff url(./images/bg.png) no-repeat top left;
            }
            .title{
                width:618px;
                height:134px;
                position:absolute;
                top:420px;
                left:150px;
                background:transparent url(./images/title.png) no-repeat top left;
            }
            #content{
                margin:0 auto;
            }
        </style>
    </head>

    <body>
        <div id="content">
            <div class="title"></div>

            <div class="navigation" id="nav">
                <div class="item user">
                    <img src="images/bg_user.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>User</h2>
                    <ul>
                        <li><a href="/login">Login/out</a></li>
                        <li><a href="profile.html">Profile</a></li>
                        <li><a href="#">Settings</a></li>
                    </ul>
                </div>
                <div class="item review">
                    <img src="images/bg_review.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Review</h2>
                    <ul>
                        <li><a href="#">History</a></li>
                        <li><a href="#">Favorite</a></li>
                    </ul>
                </div>
                <div class="item friend">
                    <img src="images/bg_friend.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Friend</h2>
                    <ul>
                        <li><a href="#">Add Friend</a></li>
                        <li><a href="#">Friend List</a></li>
                    </ul>
                </div>
                <div class="item ranking">
                    <img src="images/bg_ranking.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Ranking</h2>
                    <ul>
                        <li><p>Check your ranking among your friends.</p></li>           
                    </ul>

                </div>
                <div class="item search">
                    <img src="images/bg_search.png" alt="" width="199" height="199" class="circle"/>
                    <a href="search.html" class="icon"></a>
                    <h2>Search</h2>
                    <ul>
                        <li><p>Search any unfamiliar words here.</p></li>
                    </ul>                   
                </div>
            </div>
        </div>
        <!-- The JavaScript -->
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#nav > div').hover(
                function () {
                    var $this = $(this);
                    $this.find('img').stop().animate({
                        'width'     :'199px',
                        'height'    :'199px',
                        'top'       :'-25px',
                        'left'      :'-25px',
                        'opacity'   :'1.0'
                    },500,'easeOutBack',function(){
                        $(this).parent().find('ul').fadeIn(700);
                    });

                    $this.find('a:first,h2').addClass('active');
                },
                function () {
                    var $this = $(this);
                    $this.find('ul').fadeOut(500);
                    $this.find('img').stop().animate({
                        'width'     :'52px',
                        'height'    :'52px',
                        'top'       :'0px',
                        'left'      :'0px',
                        'opacity'   :'0.1'
                    },5000,'easeOutBack');

                    $this.find('a:first,h2').removeClass('active');
                }
            );
            });
        </script>
    </body>
</html>