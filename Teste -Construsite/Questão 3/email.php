<?php

//Import PHPMailer classes into the global namespace
//These must be at the top of your script, not inside a function
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

//required files
require 'vendor/autoload.php';

//Create an instance; passing `true` enables exceptions
if (isset($_POST["send"])) {

    $name = $_POST["nome"];
    $phone = $_POST["tel"];
    $email = $_POST["email"];
    $message = $_POST["msg"];



  $mail = new PHPMailer(true);

    //Server settings
    $mail->isSMTP(); 
    $mail->SMTPAuth   = true;                    
    $mail->Host       = 'smtp.gmail.com';       

    $mail->Username   = '';//Email do remetente
    $mail->Password   = '';//Senha do email do remetente   

    $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;         
    $mail->Port       = 465;                                              

    //Recipients
    $mail->setFrom( $email, $name);
    $mail->addAddress('', '');//Destinatário  
   

    //Content
    $mail->isHTML(true);              
    $mail->Subject = 'Novo Email';  
    $mail->Body    = '<h4>Nome: '.$name.'</h4>
                      <h4>Telefone: '.$phone.'</h4>
                      <h4>Email: '.$email.'</h4>
                      <h4>Mensagem: '.$message.'</h4>'; 
    // Success sent message alert
    if($mail->send())
    {
      header("Location: index.php?message=success");
      exit(0);
    }
    else
    {
      header("Location: index.php?message=error");
      exit(0);
    }

}
else 
{
  header("Location: index.php");
  exit(0);
}
?>