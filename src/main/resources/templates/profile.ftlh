<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Personal account</h1>
    <hr>
    <br>
    <div style="text-align: center">
        <img src="/static/images/avatar.png"
             style="border:2px solid black; border-radius: 20px" height="120">
        <br>
        <br>
        <h2>${user.name}</h2>
        <br>
        Email: <b>${user.email}</b>
        <br>
        Phone number: <b>${user.phoneNumber}</b>
        <br>
        <br>
        <#if user.isAdmin()>
            <a class="btn btn-dark mb-3" style="text-align: center; width: 100%"
               href="/admin">
                Administrator panel
            </a><br>
        </#if>
        <a class="btn btn-dark mb-3" style="text-align: center; width: 100%"
           href="/my/products">
            My products
        </a>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" style="text-align: center; width: 100%" class="btn btn-danger mb-2">
                Log out of account
            </button>
        </form>
    </div>
</@t.template>