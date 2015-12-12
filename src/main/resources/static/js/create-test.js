/**
 * Created by stuerjoris on 12/12/15.
 */


function sum()
{
    var Amplitude_big_circletj = document.getElementById('Amplitude_big_circle').value;
    var Target_widthtje = document.getElementById('Target_width').value;
    var result = Math.log(( parseInt(Amplitude_big_circletj) / parseInt(Target_widthtje) ) + 1) / Math.log(2);

    if (!isNaN(result)) {
        document.getElementById('difficulty').value = result;
    }
    document.getElementById("mydifficulty").value = result;
}


$(function()
{
    $('#btnLaunch').click(function()
    {
        $('#myModal').modal('show');
    });


    $('#btnSave').click(function()
    {
        var Amplitude_big_circle = document.getElementById("Amplitude_big_circle");
        var Target_width = document.getElementById("Target_width");
        var mydifficulty = document.getElementById("mydifficulty");

        var table = document.getElementById("sequences");
        var row = table.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);

        cell1.innerHTML = Amplitude_big_circle.value;
        cell2.innerHTML = Target_width.value;
        cell3.innerHTML = mydifficulty.value;
        cell4.innerHTML = '<input type="button" class="btn btn-danger btn-sm" value = "Delete" onClick="deleteRow(this)"/>';
        //$('#myModal').modal('hide');
    });


    $('#tester').click(function()
    {
        var email = document.getElementById("email");
        var table2 = document.getElementById("emails");
        var row = table2.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        cell1.innerHTML = email.value;
        cell2.innerHTML = '<input type="button" class="btn btn-danger btn-sm" value = "Delete" onClick="deleteRowuser(this)"/>';
    });

});

function deleteRow(obj)
{
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("sequences");
    table.deleteRow(index);
}
function deleteRowuser(obj)
{
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("emails");
    table.deleteRow(index);
}