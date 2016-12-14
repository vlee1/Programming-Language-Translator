$(document).ready(function () {

    var accessors = {
        'public':'function',
        'private':'function',
        'protect':'function'
    }
    var dataType = {
        'String': '$',
        'Integer': '$',
        'int':'$',
        'double':'$',
        'LocalDate':'$',
        'void':'$'
    }
    var classes = {
        'function ': ''
    }

    var variableList = [];
    var variables = {

    }

    var functionList = {};


    $("#text").keyup(function(event) {
        $("#result").text($("#text").val());

        var newText = event.target.value;

        for (var index in accessors) {
            var temp = new RegExp(index, 'gim');
            newText = newText.replace(temp, accessors[index]);

        }

        for (var index in dataType) {
            var temp = new RegExp(index, 'gim');
            newText = newText.replace(temp, dataType[index]);
        }

        for (var index in classes) {
            var temp = new RegExp(index, 'gim');
            newText = newText.replace(temp, classes[index]);
        }

        for (var index in dataType) {
            newText = newText.replace("$ ", "$");
        }

        var regex = new RegExp('.\\w*\\(\\)');
        var results = newText.match(regex);

        console.log(results);

        for(var index in dataType) {




            //newText = newText.replace('$', "");
        }



        $('#result').text(newText);
    })

});