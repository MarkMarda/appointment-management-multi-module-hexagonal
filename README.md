# Appointment management

## Run the proyect

```shell
# Desde raiz de proyecto

java -jar app-be-appointment-management-configuration\build\libs\app-be-appointment-management-configuration-0.0.1-SNAPSHOT.jar
```

### Run prject in intellij without install java in the machine

```shell
#Saber si se tiene el jar el application.yaml

& "C:\Users\<YOUR-USER>\.jdks\temurin-25.0.1\bin\jar.exe" tf app-be-appointment-management-configuration\build\libs\app-be-appointment-management-configuration-0.0.1-SNAPSHOT.jar | Select-String application.yaml

```

```shell
# Desde Intellij sin instalar localmente Java

& "C:\Users\<YOUR-USER>\.jdks\temurin-25.0.1\bin\java.exe" --% -Dspring.datasource.url="jdbc:mysql://localhost:<YOUR-PORT>/<YOUR-DATABASE>" -Dspring.datasource.username="root" -Dspring.datasource.password="YOUR-PASSWORD" -jar app-be-appointment-management-configuration\build\libs\app-be-appointment-management-configuration-0.0.1-SNAPSHOT.jar
```

```shell
# debug 

& "C:\Users\<YOUR-USER>\.jdks\temurin-25.0.1\bin\java.exe" --% -Dspring.datasource.url="jdbc:mysql://localhost:<YOUR-PORT>/<YOUR-DATABASE>" -Dspring.datasource.username="root" -Dspring.datasource.password="<YOUR-PASSWORD>" -jar app-be-appointment-management-configuration\build\libs\app-be-appointment-management-configuration-0.0.1-SNAPSHOT.jar --debug
```