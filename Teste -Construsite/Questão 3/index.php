<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&display=swap" rel="stylesheet">
    <link  rel="stylesheet" href="style/style.css"> 
    <title>Email</title>
</head>
<body>
    <header>
        <img src="style/logo.png" alt="Logo">
    </header>

    <div class="container">
        
        <!-- Conteúdo do bloco da esquerda -->
        <div class="bloco esquerda">
           <h1>Nome:</h1>
           <p>Vitor Lucio</p>
        </div>

         <!-- Conteúdo do bloco da direita -->
        <div class="bloco direita">
            <h1> Mensagem:</h1>
           
            <form action="email.php" method="post">
               
                <div class="info">
                    <input type="text" name="nome" placeholder="Nome" required>
                </div>
                <div class="info">
                    <input type="text" name="tel" placeholder="Telefone" require>
                </div>
                <div class="info">
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="info">
                    <textarea name="msg" placeholder="Mensagem" required></textarea>
                </div>
               <button type="submit" name="send" id="contact-submit">Enviar Mensagem</button>


            </form>
        </div>
    </div>

   
</body>
</html>