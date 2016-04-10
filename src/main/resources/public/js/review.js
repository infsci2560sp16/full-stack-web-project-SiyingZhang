/*
 * @author Siying
 * create words list through xml
 */

$(document).ready(function () {
    $.ajax("/review", {
        method: "GET",
        dataType: "xml",
        success: function (xmlDoc) {
            var container = $('.words-list.word-list-in-box');	//using class name
            var wordId = $(xmlDoc).find('wordsList').attr('wordId');
            $(xmlDoc).find('word').each(function () {
                var wordId = $(this).find('wordId').text(),
                    word = $(this).find('word').text(),
                    wordType = $(this).find('wordType').text(),
                    explanation = $(this).find('explanation').text();
                var htmlText = '<li class="list-group-item">' + 
                '\t<h4 class="list-group-item-text">' + word + '</h4>' +
                '\t<p class="list-group-item-text">' + wordType + '</p>' +
                '\t<p class="list-group-item-text">' + explanation + '</p>' +
                '\t</li>';
                container.append(htmlText);
            });

        }
    });
});