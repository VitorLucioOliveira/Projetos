async function Historico() {
    try {
        // Carregar o arquivo JSON
        const resposta = await fetch('musicas.json');
        const musicas = await resposta.json();
    const tabela = document.getElementById('historicoTable').getElementsByTagName('tbody')[0];
    tabela.innerHTML = ''; // Limpar a tabela

    // Filtrar e exibir as músicas do gênero selecionado
    const musicasFiltradas = musicas.filter(musica => musica.historico == '1');
    const top10MusicasFiltradas = musicasFiltradas.slice(0, 3);

    // Criar linhas da tabela dinamicamente
    top10MusicasFiltradas.forEach(musica => {
      const row = tabela.insertRow();
      const cell1 = row.insertCell(0);
      const cell2 = row.insertCell(1);
      const cell3 = row.insertCell(2);
      const cell4 = row.insertCell(3);
      cell1.textContent = musica.musica;
      cell2.textContent = musica.cantor;
      cell3.textContent = musica.genero;
      cell4.textContent = musica.bpm;
    });
} catch (erro) {
    console.error('Erro ao carregar ou exibir músicas:', erro);
  }
  }

  // Chamar a função ao carregar a página
  Historico();