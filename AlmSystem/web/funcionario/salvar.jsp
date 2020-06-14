<%-- 
    Document   : salvar
    Created on : 11/06/2020, 11:17:38
    Author     : TBO-002
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

    <c:import url="../layout/head.jsp"/>
    <c:import url="../layout/body.jsp"/>
        
     
    <div class="container" id="cadastro">
        <form  action="${pageContext.request.contextPath}/SalvarFuncionario" method="POST">
            <p class="text-center text-uppercase">${mensagem}</p>

            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="nome">Nome Completo</label>
                    <input type="text" class="form-control" id="nome" placeholder="Nome Completo"
                           autofocus="autofocus" name="nomePessoa" value=""/>
                    <div class="invalid-feedback">

                    </div>
                </div>

                <div class="form-group col-md-2">
                    <label for="cpf">Cpf</label>
                    <input type="text" class="form-control" id="cpf" 
                           name="cpf" />
                    <div class="invalid-feedback">

                    </div>
                </div>
                <div class="form-group col-md-3"> 
                    <label for="tipoPessoa">Tipo de Usuário</label>
                    <select  value="${fornecedor.tipoPessoa}" class="form-control" id="tipoPessoa" name="tipoPessoa" >
                        <option>Selecione</option>
                        <option value="funcionario">Funcionario</option>
                        <option value="fornecedor">Fornecedor</option>
                        <option value="administrador">Administrador do Sistema</option>
                    </select>
                    <div class="invalid-feedback">

                    </div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="nome" placeholder="digite o seu email"
                           autofocus="autofocus" name="emailPessoa" value=""/>
                    <div class="invalid-feedback">

                    </div>
                </div>
                <div class="form-group col-md-3">
                    <label for="telefone">Telefone</label>
                    <input type="phone" class="form-control" id="telefone"  type="phone" name="telefonePessoa" required=""/> 



                    <div class="invalid-feedback">

                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" id="nome" placeholder="Crie um login de usuário"
                           autofocus="autofocus" name="login" value=""/>
                    <div class="invalid-feedback">

                    </div>
                </div>
                <div class="form-group col-md-3">
                    <label for="senha">Senha</label>
                    <input type="password" placeholder="Crie uma senha" class="form-control" id="password" 
                           name="senha" />
                    <div class="invalid-feedback">

                    </div>
                </div>
                <div class="form-group col-md-3">
                    <label for="senha">Confirma Senha</label>
                    <input type="password"   placeholder="Confirme Senha" id="confirm_password" class="form-control" required>

                    <div class="invalid-feedback">

                    </div>
                </div>
            </div>
            <!------------------------------------------------------------------------------------------>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="cep">Cep</label>
                    <input  placeholder="Apenas números" class="form-control input-md" required="" 
                            name="cepPessoa"  id="cep"  type="search" maxlength="9" pattern="[0-9]+$" onblur="pesquisacep(this.value);" >

                </div>

                <div class="form-group col-md-5">
                    <label for="cidade">Cidade</label>
                    <input id="cidade" name="cidadePessoa" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                    <div class="invalid-feedback">

                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="logradouro">Logradouro</label>
                        <input id="rua" name="logradoroPessoa" class="form-control" placeholder="" required="" type="text">
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="form-group col-md-3">
                        <label for="bairro">Bairro</label>
                        <input id="bairro" name="bairroPessoa" class="form-control" placeholder="" required=""  type="text">
                        <div class="invalid-feedback">

                        </div>   

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="numero">Número</label>
                            <input type="text" class="form-control" id="numero" name="numeroPessoa"/>
                            <div class="invalid-feedback">

                            </div>
                        </div>


                        <div class="form-group col-md-2">
                            <label for="uf">UF</label>
                            <input id="estado" name="ufPessoa" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                            <div class="invalid-feedback">

                            </div>
                        </div>
                        <div class="form-group col-md-e"> 
                            <label for="paisPessoa">País</label>
                            <select  name="paisPessoa" class="form-control" id="paisPessoa" >
                                <option>Selecione</option>
                                <option value="brasil">Brasil</option>
                                <option value="paraguay">Paraguay</option>
                                <option value="bolivia">Bolívia</option>
                            </select>
                            <div class="invalid-feedback">

                            </div>
                        </div>
                        <div class="form-group col-md-1">
                            <label for="uf">Id</label>
                            <input id="id" value="${funcionario.idFuncionario}" name="idFuncionario" class="form-control" placeholder=""  readonly="readonly" type="text">
                            <div class="invalid-feedback">

                            </div>
                        </div>
                        <input type="hidden" id="id" name="id" value=""/>
                        <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                    </div>

                </div>

                <button type="submit" class="btn btn-primary btn-sm">Limpar</button>
        </form>
    </div>
</section>
</div>

 <c:import url="../layout/footer.jsp"/>
 <script src="../vendor/js/js.js" type="text/javascript"></script>
 <script src="../vendor/js/viacep.js" type="text/javascript"></script>
</html>
