package Controller;

import Model.User;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("page");


        //Login here is taken from login forms action
        //Login
        if (action.equalsIgnoreCase("Login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new UserService().getUser(username, password);

            if (user != null) {

                HttpSession session = request.getSession();

                session.setAttribute("uid", user.getId());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("user", user);

                request.setAttribute("msg", "Login Success");

                RequestDispatcher rd = request.getRequestDispatcher("Pages/dashboard.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid password or username");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }


        }

        //To redirect to register.jsp
        if (action.equalsIgnoreCase("newUsers")) {
            RequestDispatcher rd = request.getRequestDispatcher("Pages/register.jsp");
            rd.forward(request, response);
        }


        //register here is taken from register.jsp form from action attribute
        if (action.equalsIgnoreCase(("register"))) {

            User user = new User();

            //String Should be same as that in name attribute in the register.jsp
            user.setFull_name(request.getParameter("fullname"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            new UserService().insertUser(user);

            // after registration moves to login page
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        }

        //For index
        if (action.equalsIgnoreCase("index")) {

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        //Logout
        if (action.equalsIgnoreCase("logout")) {

            HttpSession session = request.getSession(false);
            session.invalidate();

            // msg should be shown in login page
            request.setAttribute("msg", "Logout Success");

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        }

        //delete
        if (action.equalsIgnoreCase("deleteUser")) {

            int id = Integer.parseInt(request.getParameter("id"));

            //UserService userService = new UserService();
            //userService.deleteUser(id);
            new UserService().deleteUser(id);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);

            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user.jsp");
            rd.forward(request, response);
        }

        //For Edit
        if (action.equalsIgnoreCase("editUser")) {

            User user = new User();
            int id = Integer.parseInt(request.getParameter("id"));
            user.setFull_name(request.getParameter("fullname"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            try {
                new UserService().updateUser(id, user);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userlist", userList);

            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user.jsp");
            rd.forward(request, response);


        }

        if (action.equalsIgnoreCase("userEdit")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            User user = new UserService().getRow(id);
            request.setAttribute("id",id);
            request.setAttribute("user","user");

            RequestDispatcher rd = request.getRequestDispatcher("Pages/update_user.jsp");
            rd.forward(request,response);

        }

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}



