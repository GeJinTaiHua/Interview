using System.Web;
using System.Web.Configuration;
using System.Web.Mvc;

namespace NETSubject.Controllers
{
    /// <summary>
    /// ASP.Net中页面传值的几种方式
    /// Request.QueryString["name"]，Request.Form("name"),
    /// Session，Cookie，Cache，
    /// Application，Server.Transfer，ViewState，Static，
    /// HttpContext的Item属性，Files，DataBase等等。
    /// </summary>
    public class ViewValueController : Controller
    {
        public ActionResult Index()
        {
            return View();

            #region 1、Request.QueryString

            //获取url中的“？”之后的参数
            string queStr = Request.QueryString["name"];

            #endregion

            #region 2、Request.Form

            //获取窗体变量集合
            string strQueForm = Request.Form["TextBox1"];

            #endregion

            #region 3、Session

            Session["name"] = "dasdda";

            string getSessionValue = Session["name"].ToString();
            //清空Session，但不结束会话
            Session.Clear();
            //结束Session会话
            Session.Abandon();

            #endregion

            #region 4、Application

            //和Session变量的区别在于，前者是所有的用户共用的全局变量，后者是各个用户独有的全局变量。
            //Application["name"] = "Label1.name";

            //Application.Lock();
            //string name = Application["name"].ToString();
            //Application.UnLock();

            #endregion

            #region 5、Cache

            //用于将需要大量服务器资源来创建的对象存储在内存中，以此大大改进应用程序的性能。
            //Cache["id"] = "TextBox1.Cache";

            #endregion

            #region 6、Cookie

            //用于在用户浏览器上存储小块的信息
            //通过HTTP头在浏览器和服务器之间来回传递的,只能包含字符串的值
            //Cookie是存放在客户端的，而session是存放在服务器端的
            HttpCookie httpCookie = new HttpCookie("testCookie", "dddssss");
            string testCookie = Request.Cookies["testCookie"].Value;

            #endregion

            #region 7、Context.Items["id"]

            HttpContext.Items["id"] = "TextBox1.id";
            //移除项
            HttpContext.Items.Remove("id");

            #endregion

            #region 8、ViewState

            ////数据保存
            //ViewState["id"] = "TextBox1.Text";
            ////数据取出
            //string idStr = ViewState["id"].ToString();
            ////数据移除
            //ViewState.Remove("id");

            #endregion

            #region 9、web.config和machine.config

            //适合保存一些字符串常量，如数据库连接信息
            //文件中某些设置会导致文件被修改后Web运用程序的重启。
            WebConfigurationManager.AppSettings.Set("userName", "userNameuserName");
            string userName = WebConfigurationManager.AppSettings["userName"];

            #endregion

            #region 10、Static

            #endregion
        }
    }
}