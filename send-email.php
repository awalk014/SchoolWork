<?php
// Error reporting
ini_set('display_errors', 1);
error_reporting(E_ALL);

// CORS headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");
header("Access-Control-Allow-Methods: POST, OPTIONS");

if ($_SERVER['REQUEST_METHOD'] === 'OPTIONS') {
    http_response_code(200);
    exit();
}

// Load PHPMailer
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require 'PHPMailer/PHPMailer.php';
require 'PHPMailer/SMTP.php';
require 'PHPMailer/Exception.php';

// Get JSON data
$data = json_decode(file_get_contents("php://input"), true);

if (!$data || !isset($data['name'], $data['email'], $data['message'])) {
    http_response_code(400);
    echo "Invalid input";
    exit();
}

// Sanitize input
$name = htmlspecialchars($data['name']);
$email = filter_var($data['email'], FILTER_VALIDATE_EMAIL);
$message = htmlspecialchars($data['message']);

if (!$email) {
    http_response_code(400);
    echo "Invalid email address";
    exit();
}

// Setup mail
$mail = new PHPMailer(true);

try {
    $mail->isSMTP();
    $mail->Host = 'smtp.gmail.com';
    $mail->SMTPAuth = true;
    $mail->Username = 'placeholder_email';        // Your Gmail address
    $mail->Password = 'placeholder_password';          // App Password from Google
    $mail->SMTPSecure = 'tls';
    $mail->Port = 587;

    $mail->setFrom('contact@benwalkerbackend.site', 'Ben Walker Website');
    $mail->addAddress('yourgmail@gmail.com');       // Send the email to yourself
    $mail->addReplyTo($email, $name);               // Allow reply to user

    $mail->isHTML(false);
    $mail->Subject = "New Contact Message from $name";
    $mail->Body = "Name: $name\nEmail: $email\n\nMessage:\n$message";

    $mail->send();
    echo "Message sent successfully";
} catch (Exception $e) {
    http_response_code(500);
    echo "Mailer Error: " . $mail->ErrorInfo;
}
