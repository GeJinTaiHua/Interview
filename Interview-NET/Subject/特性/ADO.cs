using System;
using System.Collections.Generic;
using System.Data.SqlClient;

namespace Subject
{
    /// <summary>
    /// ADO.NET
    /// </summary>
    public class Test_ADO
    {
        public void Test_Insert()
        {
            // 创建连接对象，并使用using释放（关闭），连接用完后会被自动关闭
            using (SqlConnection conn = new SqlConnection("Data Source=MYDB.;Initial Catalog=MyTB;User Id=GJTH;Password=MM;"))
            {
                conn.Open();

                // 创建命令对象，指定要执行sql语句与连接对象conn
                string sql = "INSERT INTO  Car([Title] ,[Speed] ,[Info]) VALUES(@Ttile,@Speed,@Info)";
                SqlCommand cmd = new SqlCommand(sql, conn);

                // 指定参数
                cmd.Parameters.Add(new SqlParameter("@Ttile", "大众"));
                cmd.Parameters.Add(new SqlParameter("@Speed", 200));
                cmd.Parameters.Add(new SqlParameter("@Ttile", "大众大"));

                // 执行，返回影响行数
                int rows = cmd.ExecuteNonQuery();
            }
        }

        public void Test_SelectOne()
        {
            SqlConnection conn = null;
            try
            {
                conn = new SqlConnection("server=.;uid=sa;pwd=sa;database=MyCar");
                conn.Open();

                string sql = "select COUNT(*) from Car";
                SqlCommand cmd = new SqlCommand(sql, conn);

                // 执行查询返回单行单列的值，Object类型
                Object result = cmd.ExecuteScalar();
            }
            finally
            {
                conn.Close();
            }
        }

        public void Test_SelectAll()
        {
            List<object> result = new List<object>();

            using (SqlConnection conn = new SqlConnection("server=.;uid=sa;pwd=sa;database=MyCar"))
            {
                conn.Open();

                string sql = "select Id,Title,Speed,Info from Car";
                SqlCommand cmd = new SqlCommand(sql, conn);

                // 执行查询返回结果集
                SqlDataReader sdr = cmd.ExecuteReader();

                // 下移游标，读取一行，如果没有数据了则返回false
                while (sdr.Read())
                {
                    result.Add(new object
                    {
                        //Id = Convert.ToInt32(sdr["Id"]),
                        //Title = sdr["Title"],
                        //Speed = Convert.ToInt32(sdr["Speed"]),
                        //Info = sdr["Info"]
                    });
                }
                // 关闭
                sdr.Close();
            }
        }
    }
}
