import AccountCircle from "@mui/icons-material/AccountCircle";
import LockIcon from "@mui/icons-material/Lock";
import VisibilityIcon from "@mui/icons-material/Visibility";
import VisibilityOffIcon from "@mui/icons-material/VisibilityOff";
import {
  Box,
  Button,
  FormControl,
  FormHelperText,
  Grid,
  IconButton,
  Input,
  InputAdornment,
  InputLabel,
  Stack,
  Typography,
} from "@mui/material";
import { Formik } from "formik";
import { motion } from "framer-motion";
import React from "react";
import { useDispatch } from "react-redux";
import * as Yup from "yup";

import alertSlice from "../../toolkits/alert/slice";
import authSlice from "../../toolkits/auth/slice";
import { AuthWrapper } from "./login.style";

const Login = () => {
  const [showPassword, setShowPassword] = React.useState(false);
  const dispatch = useDispatch();

  const onLoginBtnClicked = (values) => {
    if (values.username === "") {
      dispatch(alertSlice.actions.error("Chưa nhập username!"));
    } else if (values.password === "") {
      dispatch(alertSlice.actions.error("Chưa nhập mật khẩu!"));
    } else {
      login(values);
    }
  };

  const login = (values) => {
    dispatch(authSlice.actions.login(values));
  };

  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  };

  return (
    <AuthWrapper>
      <Grid container spacing={3}>
        <Grid item container xs={12} justifyContent="center">
          <Typography variant="h3" sx={{ fontSize: "2rem" }}>
            Đăng nhập
          </Typography>
          {/* <Stack direction="column" alignItems={"center"}>
            <Typography variant="h3" sx={{ fontSize: "1.5rem" }}>
              Login
            </Typography>
            <FormControl sx={{ pt: "1.5ch" }}>
              <RadioGroup
                row
                aria-labelledby="auth-row-radio-buttons-group-label"
                name="row-radio-buttons-group"
                defaultValue="viewer"
              >
                <FormControlLabel
                  value="viewer"
                  control={<Radio />}
                  label="Viewer"
                />
                <FormControlLabel
                  value="editer"
                  control={<Radio />}
                  label="Editer"
                />
                <FormControlLabel
                  value="manager"
                  control={<Radio />}
                  label="Manager"
                />
              </RadioGroup>
            </FormControl>
          </Stack> */}
        </Grid>

        <Grid item xs={12}>
          <>
            <Formik
              initialValues={{
                username: "",
                password: "",
              }}
              validationSchema={Yup.object().shape({
                username: Yup.string()
                  .max(20)
                  .required("Tên đăng nhập là bắt buộc"),
                password: Yup.string().max(20).required("Mật khẩu là bắt buộc"),
              })}
              onSubmit={(values) => onLoginBtnClicked(values)}
            >
              {({
                errors,
                handleBlur,
                handleChange,
                handleSubmit,
                isSubmitting,
                touched,
                values,
              }) => (
                <form noValidate onSubmit={handleSubmit}>
                  <Grid container spacing={3}>
                    <Grid item xs={12}>
                      <Stack spacing={1}>
                        <Box sx={{ display: "flex", alignItems: "flex-end" }}>
                          <AccountCircle
                            sx={{ color: "action.active", mr: 1, my: 0.5 }}
                          />
                          <FormControl
                            sx={{ width: "100%" }}
                            variant="standard"
                          >
                            <InputLabel htmlFor="standard-adornment-username">
                              Tên đăng nhập
                            </InputLabel>
                            <Input
                              id="standard-adornment-username"
                              type="text"
                              value={values.username}
                              name="username"
                              onBlur={handleBlur}
                              onChange={handleChange}
                              fullWidth
                              error={Boolean(
                                touched.username && errors.username
                              )}
                            />
                          </FormControl>
                        </Box>
                        {touched.username && errors.username && (
                          <FormHelperText
                            error
                            id="standard-weight-helper-text-username-login"
                          >
                            {errors.username}
                          </FormHelperText>
                        )}
                      </Stack>
                    </Grid>
                    <Grid item xs={12}>
                      <Stack spacing={1}>
                        <Box sx={{ display: "flex", alignItems: "flex-end" }}>
                          <LockIcon
                            sx={{ color: "action.active", mr: 1, my: 0.5 }}
                          />
                          <FormControl
                            sx={{ width: "100%" }}
                            variant="standard"
                          >
                            <InputLabel htmlFor="standard-adornment-password">
                              Mật khẩu
                            </InputLabel>
                            <Input
                              id="standard-adornment-password"
                              type={showPassword ? "text" : "password"}
                              value={values.password}
                              name="password"
                              onBlur={handleBlur}
                              onChange={handleChange}
                              fullWidth
                              error={Boolean(
                                touched.password && errors.password
                              )}
                              endAdornment={
                                <InputAdornment position="end">
                                  <IconButton
                                    aria-label="toggle password visibility"
                                    onClick={handleClickShowPassword}
                                  >
                                    {showPassword ? (
                                      <VisibilityOffIcon />
                                    ) : (
                                      <VisibilityIcon />
                                    )}
                                  </IconButton>
                                </InputAdornment>
                              }
                            />
                          </FormControl>
                        </Box>
                        {touched.password && errors.password && (
                          <FormHelperText
                            error
                            id="standard-weight-helper-text-password-login"
                          >
                            {errors.password}
                          </FormHelperText>
                        )}
                      </Stack>
                    </Grid>
                    <Grid item xs={12}>
                      <motion.div
                        whileHover={{ scale: 1 }}
                        whileTap={{ scale: 0.9 }}
                      >
                        <Button
                          disableElevation
                          fullWidth
                          size="large"
                          type="submit"
                          variant="contained"
                        >
                          Đăng nhập
                        </Button>
                      </motion.div>
                    </Grid>
                  </Grid>
                </form>
              )}
            </Formik>
          </>
        </Grid>
      </Grid>
    </AuthWrapper>
  );
};

export default Login;
