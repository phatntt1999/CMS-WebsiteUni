console.log("z");
$("#add-new-contribution").hide();
$(document).ready(function () {
    $("#add-post").click(function () {
        $("#add-new-contribution").show();
    });
});
$(document).ready(function () {
    $("#close").click(function () {
        $("#add-new-contribution").hide();
    })
})
