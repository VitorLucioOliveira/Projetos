function calcularSaldo(vitorias, derrotas) {
  var Saldo = vitorias - derrotas;
  nivel = "";

  if (Saldo < 10) nivel = "Ferro";

  if (Saldo > 11 && Saldo < 20) nivel = "Bronze";

  if (Saldo > 21 && Saldo < 50) nivel = "Prata";

  if (Saldo > 51 && Saldo < 80) nivel = "Ouro";

  if (Saldo > 7.001 && Saldo < 8.0) nivel = "Diamante";

  if (Saldo > 81 && Saldo < 90) nivel = "Diamante";

  if (Saldo > 91 && Saldo < 100) nivel = "Lendário";

  if (Saldo >= 101) nivel = "Imortal";

  console.log("O Herói tem o Saldo de " + Saldo + " e está no nível de " + nivel);
  return 0;
}

const prompt = require("prompt-sync")();

var vitorias = parseInt(prompt("Vitórias do Heroi: "));
var derrotas = parseInt(prompt("Derrotas do Heroi: "));

var win = calcularSaldo(vitorias, derrotas);