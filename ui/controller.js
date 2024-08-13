var SERVER_URL = "http://env-6850457.sh2.hidora.net:8080";

var isBattleRunning = false;

function cleanScreen() {

    console.log('Cleaning');
    $("#fight-form").find("input[name='human-card-selected']").val("");
    $('.multiplication-a').empty();
    $('.multiplication-b').empty()
}

function playBattle() {
    $.ajax({
        url: SERVER_URL + "/battles/play"
    }).then(function(data){
        $('#human-cards-body').empty();
        $('#computer-cards-body').empty();

        console.log(data);

        data.humanPlayer.pokemonCardResponses.forEach(function(row){
            $('#human-cards-body')
                                             .append('<tr>' +
                                             '<td>' + row.healthPoints + '</td>' +
                                             '<td>' + row.attackPoints + '</td>' +
                                             '</tr>');
        });

        data.computerPlayer.pokemonCardResponses.forEach(function(row){
            $('#computer-cards-body')
                                             .append('<tr>' +
                                             '<td>' + row.healthPoints + '</td>' +
                                             '<td>' + row.attackPoints + '</td>' +
                                             '</tr>');
        });
    });
}

function fight(humanCardSelected) {
    console.log(humanCardSelected);


    var computerCardsSize = $('#human-cards-body tr').length;
    var computerCardSelected = Math.floor(Math.random() * computerCardsSize);

    var data = {
        healthPointsHumanSelected: $('#human-cards-body tr:eq(' + humanCardSelected + ') td:eq(0)').text(),
        attackPointsHumanSelected: $('#human-cards-body tr:eq(' + humanCardSelected + ') td:eq(1)').text(),
        healthPointsComputerSelected: $('#computer-cards-body tr:eq(' + computerCardSelected + ') td:eq(0)').text(),
        attackPointsComputerSelected: $('#computer-cards-body tr:eq(' + computerCardSelected + ') td:eq(1)').text()
    };

    $.ajax({
        url: SERVER_URL + "/battles/fight",
        type: 'POST',
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: false,
        success: function(result) {
            console.log(result);

            $.ajax({
                url: SERVER_URL + "/fights"
            }).then(function(data){
                console.log(data);

                $('#fight-list-body').empty();

                data.fights.forEach(function(row){
                    $('#fight-list-body')
                                         .append('<tr>' +
                                         '<td>' + row.humanHealth + '</td>' +
                                         '<td>' + row.humanAttack + '</td>' +
                                         '<td>' + row.computerHealth + '</td>' +
                                         '<td>' + row.computerAttack + '</td>' +
                                         '</tr>');
                });
            });
        }
    });

}

$(document).ready(function(){
    cleanScreen();

    $("#play-form").submit(function(event){

        event.preventDefault();
        console.log('Play battle');


        playBattle();
    });

    $("#fight-form").submit(function(event){
        event.preventDefault();
        console.log('Fight');

        var form = $(this);
        var humanCardSelected = form.find("input[name='human-card-selected']").val();

        fight(humanCardSelected);

    });
});
