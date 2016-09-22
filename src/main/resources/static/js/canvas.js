/**
 * Created by daniel on 16/09/16.
 */


var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');
var isDrawing;
ctx.globalAlpha = 1;


canvas.onmousedown = function(e) {
    isDrawing = true;
    ctx.beginPath();
    ctx.moveTo(e.offsetX, e.offsetY);

};
canvas.onmousemove = function(e) {
    if (isDrawing) {
        ctx.lineTo(e.offsetX, e.offsetY);
        ctx.stroke();
    }
};
canvas.onmouseup = function() {
    isDrawing = false;
    ctx.closePath();
    var data = canvas.toDataURL();
    $.post("/save",{ canvas: data} );
};



function getContent(){
    $.get("/getCanvas",function (canvasData) {
        if(canvasData){
            var myCanvas = document.getElementById('canvas');
            var ctx = myCanvas.getContext('2d');
            ctx.font = 'italic 16pt Calibri';
            ctx.fillText('Lousa reativa. Desenhe e visualize em tempo real', 50, 50);
            ctx.fillText('E lembre-se.. o conteúdo não pode ser apagado e é visto por todos! =)', 50, 70);
            var img = new Image;
            img.onload = function(){
                ctx.drawImage(img,0,0); // Or at whatever offset you like
            };
            img.src = canvasData;
        }
    });
}
setInterval(getContent, 2000);
