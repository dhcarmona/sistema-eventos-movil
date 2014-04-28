sistema-eventos-movil
=====================

  La dirección principal de login es
  login/login.html

  - Recordatorio -> correr 'bundle install' para instalar los Gems necesarios indicados en el Gemfile,
  - y correr "rake db:schema:load" para cargar el schema de la base de datos (necesita tener mysql instalado).
  - La dirección web es http://semcr.no-ip.biz/, esto cuando la computadora está encendida y el nginx    activado.


  - Los endpoints son:
  -   http://semcr.no-ip.biz/login/login para el login
  -     Puede entrar desde el root http://semcr.no-ip.biz/
  -   http://semcr.no-ip.biz/usuarios para los usuarios
  -   http://semcr.no-ip.biz/establecimientos para los establecimientos
  -   http://semcr.no-ip.biz/eventos para los eventos
  

  Cada uno de los endpoints, excepto el de login, tiene sus acciones de new, edit y delete, asociado a su pagina, por ejemplo:
  
  -http://semcr.no-ip.biz/usuarios/1/edit    para editar el usuario 1 (si esta logueado como él).
  -http://semcr.no-ip.biz/usuarios/new       para crear un nuevo usuario
  
  En el caso de los usuarios, sólo se puede acceder a edit y a delete, si se está logueado como ese usuario, de otra forma será direccionado a la pantalla de login, o a su perfil.
  
  En el caso de los eventos y establecimientos, ambos tienen sus índices de la forma
  
  - http://semcr.no-ip.biz/establecimientos.json
  - http://semcr.no-ip.biz/eventos.json
  
  Además, cada evento y establecimiento puede ser consultado por JSON, individualmente.

  Así mismo, los recursos se pueden obtener como JSON indicándolo de la forma:
  
   -   http://semcr.no-ip.biz/recurso/1.json
  
  De igual manera con los establecimientos y los eventos.
  Toda petición a través de JSON debe autenticarse con el AppKey, que para propósito de revisión es       ?appkey=1405ee0b5234c53980d46d493ae2a0cb.
  
