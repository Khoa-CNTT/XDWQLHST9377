import * as React from "react";
import { Formik } from "formik";
import { useDispatch } from "react-redux";
import authSlice from "../../toolkits/auth/slice";
import { AuthWrapper } from "./login.style";
import * as Yup from "yup";
import { motion } from "framer-motion";
import AccountCircle from "@mui/icons-material/AccountCircle";
import LockIcon from "@mui/icons-material/Lock";
import VisibilityIcon from "@mui/icons-material/Visibility";
import VisibilityOffIcon from "@mui/icons-material/VisibilityOff";
import {
  Box,
  Button,
  FormControl,
  FormHelperText,
  IconButton,
  Input,
  InputAdornment,
  InputLabel,
  Stack,
  Typography,
} from "@mui/material";
import Grid from "@mui/material/Grid2";

const SignInSide = () => {
  const [showPassword, setShowPassword] = React.useState(false);
  const dispatch = useDispatch();

  const handleClickShowPassword = () => setShowPassword(!showPassword);

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

  return (
    <AuthWrapper>
      <Grid container spacing={3}>
        <Grid container justifyContent="center">
          <Typography variant="h3" sx={{ fontSize: "2rem" }}>
            Đăng nhập
          </Typography>
        </Grid>
        <Grid>
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
                    <Grid>
                      <Stack spacing={1}>
                        <Box sx={{ display: "flex", alignItems: "flex-end" }}>
                          <AccountCircle
                            sx={{ color: "action.active", mr: 1, my: 0.5 }}
                          />
                          <FormControl sx={{ width: 300 }} variant="standard">
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
                    <Grid>
                      <Stack spacing={1}>
                        <Box sx={{ display: "flex", alignItems: "flex-end" }}>
                          <LockIcon
                            sx={{ color: "action.active", mr: 1, my: 0.5 }}
                          />
                          <FormControl sx={{ width: 300 }} variant="standard">
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
                    <Grid>
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

export default SignInSide;
