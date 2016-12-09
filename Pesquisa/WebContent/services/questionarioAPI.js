angular.module("questionario").factory("questionarioAPI", function ($http, config){
	var _getCategorias = function(){
		return $http.get(config.baseURL + "/CategoriaControl.do");
	};
	var _getAutores = function(){
		return $http.get(config.baseURL + "/AutorControl.do");
	};
	var _getEditoras = function(){
		return $http.get(config.baseURL + "/EditoraControl.do");
	};
	var _getLivros = function(){
		return $http.get(config.baseURL + "/LivroControl.do");
	};
	
	var _setQuestionario = function(livro){
		return $http.post(config.baseURL + "/QuestionarioControl.do", livro);
	};
	return {
		getCategorias : _getCategorias,
		getAutores : _getAutores,
		getEditoras : _getEditoras,
		getLivros : _getLivros,
		setQuestionario: _setQuestionario
	};
});