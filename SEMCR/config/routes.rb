SEMCR::Application.routes.draw do
  resources :ev_comentarios

  resources :est_comentarios

  devise_for :usuarios
  root 'login#login'
  resources :eventos


  resources :establecimientos
  resources :usuarios
  resources :establecimientos do
    post 'agregar_comentario', :on => :member
  end
  resources :establecimientos do
    get 'comentarios', :on => :member
  end
  resources :eventos do
    get 'nuevo_horario', :on => :member
  end

  resources :eventos do
    post 'agregar_horario', :on => :member
  end

  resources :eventos do
    post 'agregar_tipo', :on => :member
  end


  post "login/login"
  get "usuarios/new"
  get "usuarios/show"
  get "login/login"


end
