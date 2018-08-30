require 'sinatra'

get '/' do
    halt 503, 'Busy'
end
