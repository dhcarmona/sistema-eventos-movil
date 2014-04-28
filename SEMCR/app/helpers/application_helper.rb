module ApplicationHelper
#Manejar avisos de error, se formatean con CSS por Bootstrap
def flash_class(level)
    case level
        when :aviso then "alert alert-info"
        when :exito then "alert alert-success"
        when :error then "alert alert-error"
        when :alerta then "alert alert-error"
    end
end



end
