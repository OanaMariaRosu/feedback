# feedback cloud project

<h1> Pasi instalare prerequisites </h1>
<ol>
  <li>Instalare Java 8</li>
  <li>Instalare Maven 3.3.9</li>
  <li>Instalare IDE pt Java (de preferat Eclipse, dar e ok si NetBeans, IntelliJ etc.)</li>
  <li>Instalare Google SDK + Python 2.7 (https://dl.google.com/dl/cloudsdk/channels/rapid/GoogleCloudSDKInstaller.exe) </li>
  <li>Rulati comanda <strong>gcloud init</strong> pentru a va configura contul de google si proiectul </li>
  <li>Rulati comanda <strong>gcloud components install app-engine-java</strong></li>
</ol>

<h1> Rulare proiect local </h1>
<ol>
  <li>Check-out la proiect local</li>
  <li>Deschideti Command Prompt/Terminal/PowerShell</li>
  <li>Rulati comanda <strong>cd YOUR_CHECKOUT_PATH/feedback</strong></li>
  <li>Rulati comanda <strong>mvn clean install</strong></li>
  <li>Rulati comanda <strong>mvn spring-boot:run</strong></li>
  <li>Testati aplicatia accesand <em>localhost:8080</em></li>
</ol>

<h1> Rulare proiect in Cloud </h1>
<ol>
  <li>Urmati pasii descrisi in README: https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/helloworld-springboot</li>
</ol>

