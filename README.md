sistema-eventos-movil
=====================

  La dirección principal de login es
  login/login.html

  - Recordatorio -> correr 'bundle install' para instalar los Gems necesarios indicados en el Gemfile
  - La dirección web es http://semcr.no-ip.biz/login/login , esto cuando la computadora está encendida y el nginx    activado.


  - Los endpoints son:
  -   http://semcr.no-ip.biz/login/login para el login
  -   http://semcr.no-ip.biz/usuarios para los usuarios
  -   http://semcr.no-ip.biz/establecimientos para los establecimientos
  -   http://semcr.no-ip.biz/eventos para los eventos

  Cada uno de los endpoints, excepto el de login, tiene sus acciones de new, edit y delete, asociado a su pagina, por ejemplo:
  
  -http://semcr.no-ip.biz/usuarios/1/edit    para editar el usuario 1
  -http://semcr.no-ip.biz/usuarios/new       para crear un nuevo usuario
  
  Así mismo, los recursos se pueden obtener como JSON indicándolo de la forma:
  
   -   http://semcr.no-ip.biz/usuarios/1.json
  
  De igual manera con los establecimientos y los eventos.

  Los endpoints son completamente inseguros por ahora, los aseguraremos mediante sesiones y application keys para la entrega final.
  
