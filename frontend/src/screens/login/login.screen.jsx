import * as React from "react";
import Box from "@mui/material/Box";
import IconButton from "@mui/material/IconButton";
import OutlinedInput from "@mui/material/OutlinedInput";
import InputLabel from "@mui/material/InputLabel";
import InputAdornment from "@mui/material/InputAdornment";
import FormControl from "@mui/material/FormControl";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Visibility from "@mui/icons-material/Visibility";
import VisibilityOff from "@mui/icons-material/VisibilityOff";
import { login } from "../../services/auth.service";
import { setLocalData } from "../../services/localStorage";
import { isLoggedInText } from "../../utils/constants";
// import { useDispatch } from "react-redux";
import authSlice from "../../toolkits/auth/slice";

export default function SignInSide() {
  const [showPassword, setShowPassword] = React.useState(false);
  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [error, setError] = React.useState("");
  // const dispatch = useDispatch();

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleMouseUpPassword = (event) => {
    event.preventDefault();
  };

  // const login = (values) => {
  //   dispatch(authSlice.actions.login(values));
  // };

  const handleLogin = async () => {
    setError("");

    try {
      const res = await login({ username, password });

      const token = res?.data?.accessToken;
      const role = res?.data?.role;

      // console.log("****Token", token);
      if (token) {
        setLocalData("accessToken", token);
        setLocalData(isLoggedInText, true);
        setLocalData("role", role);

        window.location.reload();
      } else {
        setError("Thông tin đăng nhập không hợp lệ");
      }
    } catch (err) {
      console.error("Login error", err);
      setError("Đăng nhập thất bại. Vui lòng kiểm tra lại.");
    }
  };

  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        mt: 4,
      }}
    >
      <FormControl sx={{ m: 1, width: "30ch" }} variant="outlined">
        <InputLabel htmlFor="outlined-adornment-username">Username</InputLabel>
        <OutlinedInput
          id="outlined-adornment-username"
          label="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </FormControl>

      <FormControl sx={{ m: 1, width: "30ch" }} variant="outlined">
        <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
        <OutlinedInput
          id="outlined-adornment-password"
          type={showPassword ? "text" : "password"}
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          endAdornment={
            <InputAdornment position="end">
              <IconButton
                aria-label={showPassword ? "hide password" : "show password"}
                onClick={handleClickShowPassword}
                onMouseDown={handleMouseDownPassword}
                onMouseUp={handleMouseUpPassword}
                edge="end"
              >
                {showPassword ? <VisibilityOff /> : <Visibility />}
              </IconButton>
            </InputAdornment>
          }
          label="Password"
        />
      </FormControl>

      {error && (
        <Typography color="error" variant="body2" sx={{ mt: 1 }}>
          {error}
        </Typography>
      )}

      <Button
        variant="contained"
        sx={{ mt: 2, width: "30ch" }}
        onClick={handleLogin}
      >
        Đăng nhập
      </Button>
    </Box>
  );
}
