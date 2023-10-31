const prompt = require("prompt-sync")();




var nome = prompt("Nome do Heroi: ");
var xp = parseInt(prompt("XP do Heroi: "));
var nivel = 0;


  if(xp <1.00)
    nivel = "Ferro";
    

  if(xp> 1.001 && xp < 2.0000)
    nivel = "Bronze";
    

    if(xp> 2.001 && xp < 5.0000)
    nivel = "Prata";
    

  if(xp> 6.001 && xp < 7.0000)
    nivel = "Ouro";
    

  if(xp> 7.001 && xp < 8.0000)
    nivel = "Platina";
    

  if(xp> 8.001 && xp < 9.0000)
    nivel = "Ascendente";
    

  if(xp> 9.001 && xp < 10.000)
    nivel = "Imortal";
    

  if(xp> 10.001)
    nivel = "Radiante";
    


console.log("O Herói de nome "+ nome +" está no nível de "+ nivel);