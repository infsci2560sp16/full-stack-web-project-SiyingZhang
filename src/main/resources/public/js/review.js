/*
 * @author Siying
 * create words list through xml
 */

$(document).ready(function () {
    $.ajax("/myWordsList", {
        method: "GET",
        dataType: "xml",
        success: function (xmlDoc) {
            var container = $('.words-list.word-list-in-box');	//using class name
            var createdBy = $(xmlDoc).find('wordList').attr('createdBy');
            $(xmlDoc).find('group').each(function () {
                var groupId = $(this).find('groupId').text(),
                    groupName = $(this).find('groupName').text(),
                    latestPost = $(this).find('latestPost').text(),
                    hasBgImg = $(this).find('hasBgImg').text();
                var htmlText = '<li class="item">' +
                    '\t<div class="product-img">' +
                    '\t\t<img src="dist/img/group/'+ ((hasBgImg === "true")?groupId:"default")+'/b-50x50.jpg" alt="Product Image">' +
                    '\t</div>' +
                    '<div class="product-info">' +
                    '\t<a href="javascript#" class="product-title">'+ groupName +
                    '<span class="label label-warning pull-right">34</span></a>' +
                    '\t\t<span class="product-description">'+latestPost+'</span>' +
                    '\t</div>' +
                    '</li>';
                container.append(htmlText);
            });

        }
    });
});