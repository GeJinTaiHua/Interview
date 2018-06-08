using Subject;
using System.Web.Mvc;

namespace NETSubject.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            int a1 = new Fibonacci().GetFibonacci(5);

            int a = 1;
            int b = 2;
            new Swap().Swap4(ref a, ref b);

            new Test_Collection().QueueOperation();
            new Test_String().Test2();
            new Test_Dictionary().Sort();
            new Test_Decimal().Round(); 
            new Test_Foreach().Run();
            new Test_Override().Run();

            var result = new Josephus().GetLastOne1(41, 3);
            var result2 = new Narcissus().GetN(3);

            Response.Redirect("/ViewValue/Index?name=QueryStringName");
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}