# EmployeeApp

Workshop session 7 software engineering.

Java web project using jsp and servlets and Apache TOmcat to deploy the project.

## Installation

For this project it is required to have installed:
- [Java JDK](https://www.oracle.com/co/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)

To check that both Java and Maven have been installed run

```bash
java --version
```

```bash
mvn -version
```

## Usage

To execute this project, it is recommended to have VS code and the extension “extension pack for java” and "community server connectors" to deploy the WAR.

Once the project is downloaded use the key combination ctrl + shift + P:

[![execute](https://i.postimg.cc/TY2NcHWH/Captura-de-pantalla-2024-09-14-154949.png)](https://postimg.cc/w3Pkq22h)

And click the "clean" option, this will allow maven dependencies to be created in the project:

[![clean](https://i.postimg.cc/5tH898Q3/Captura-de-pantalla-2024-09-14-155233.png)](https://postimg.cc/B80jMLgL)

Once the dependencies have been installed, run the combination ctrl +shift + P again:

[![execute](https://i.postimg.cc/TY2NcHWH/Captura-de-pantalla-2024-09-14-154949.png)](https://postimg.cc/w3Pkq22h)

And this time we chose the custom option:

[![custom](https://i.postimg.cc/zGqr1kMs/Captura-de-pantalla-2024-09-14-155412.png)](https://postimg.cc/0bX3Y79n)

We will be prompted to enter a text entry, we will type “clean package” to create the WAR that will be deployed on our server.

[![clean package](https://i.postimg.cc/MpLdY6y9/Captura-de-pantalla-2024-09-14-155428.png)](https://postimg.cc/NK16swCX)

The war file will be located in the assets folder so once found we press right click and in the options we look for “run on server”, choose the Apache server and we will be able to run the project.

## Contributors

Proyect created by:

### - Esteban Coronado
[![Github](https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white)](https://github.com/Esteban-Coronado)
### - William Cely
[![Github](https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white)](https://github.com/WilliamC111)
### - Andrés Maldonado
[![Github](https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white)](https://github.com/AndresMaldonado200338)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/amaldonados/)