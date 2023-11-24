document.getElementById("formCadastro").addEventListener("submit", function (event) {
    event.preventDefault();

    var nome = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var senha = document.getElementById("password").value;

    var conta = {
        nome_usuario: nome,
        email_usuario: email,
        senha_usuario: senha
    };

    axios.post("http://localhost:6789/cadastro/insert", conta)
        .then((response) => {
            console.log("Dados recebidos da API:",response.data);
            // Exibir a mensagem de sucesso
            document.getElementById("success-message").textContent = "Cadastrado com sucesso!";
            // Limpar a mensagem de erro se a requisição for bem-sucedida
            document.getElementById("error-message").textContent = "";

            // Tornar a barra de progresso visível
            var progress = document.getElementById("progress");
            progress.style.display = "block";

            var value = 0;
            var interval = setInterval(function() {
                value++;
                progress.value = value;
                if (value >= 100) clearInterval(interval);
            }, 20); // Atualiza a cada 20 milissegundos para um total de 2 segundos

            // Redirecionar para a página de login após um cadastro bem-sucedido
            // com um atraso de 2 segundos (2000 milissegundos)
            setTimeout(function() {
                window.location.href = "login.html";
            }, 2000);
        })
        .catch((error) => {
            console.error("Erro ao enviar requisição:", error);
            // Exibir a mensagem de erro
            document.getElementById("error-message").textContent = "E-mail já cadastrado";
            // Limpar a mensagem de sucesso se a requisição falhar
            document.getElementById("success-message").textContent = "";
        });

});