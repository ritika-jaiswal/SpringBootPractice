import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from '@mui/material/Button';
import { useNavigate } from "react-router-dom";
import CourseServices from "../services/CourseServices";
import Authentication from "./Authentication";

const LoginField = () =>{
    const navigate = useNavigate();
    // const [isLogin, setIsLogin] = useState(false);
    // let setIsLogin = false;
    // useEffect(() => {

    // },[isLogin])
    const [accessToken, setAccessToken] = useState(localStorage.getItem('accessToken'));
    const [data, setData] = useState({
      email: "",
      password: "",
  
    });
    const handleChange = (e) => {
      const value = e.target.value;
      setData({ ...data, [e.target.name]: value });
    };
    const handleLoginIn = (e) => {
      // console.log(e.target.value)
      e.preventDefault();
      CourseServices.loginUser(data)
        .then((response) => {
          // console.log(response.data.jwtToken);
          setAccessToken(response.data.jwtToken);
          localStorage.setItem('accessToken', response.data.jwtToken);
          navigate("/courseList");
        })
        .catch((error) => {
          console.log(error);
        });
    };
  console.log(accessToken)
    return(
        <>
         <Box>
        <h1 className="flex justify-center items-center text-center text-lg text-white font-semibold mt-[8rem]">LogIn</h1>
        <div className="flex ml-60 items-center mx-80 w-[80%] h-[44%] ">
        <div className="flex-col  bg-slate-100 shadow-lg border-4 rounded-2xl">
      
          <div className="flex-col pt-2 px-4">Enter your email:
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="email"
              value={data.email}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
         
          <div className="flex-col pt-2 px-4">Enter Password
          <div className="flex-col w-full mt-2">
            <TextField
              id="outlined-basic"
              name="password"
              value={data.password}
              onChange={(e) => handleChange(e)}
              variant="outlined"
              size="large"
              inputProps={{
                style: {
                  height: "5px",
                  width: "[10rem]",
                },
              }}
            />
          </div>
          </div>
          <div className=" flex my-4 justify-center">
          <Button variant="contained" style={{background:"blue-400"}} onClick={handleLoginIn}>Login</Button>
          </div>
        
          {/* <div> <Authentication data = {setIsLogin}/></div> */}
        
        </div>
      
        </div>
        
      </Box> 
        </>
    )
}

export default LoginField