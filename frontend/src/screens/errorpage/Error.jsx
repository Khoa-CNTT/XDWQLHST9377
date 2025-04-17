import { Box, Grid } from "@mui/material";
import Lottie from "lottie-react";
import React from "react";

import error404Lottie from "../../assets/404error.json";

const Error404 = () => {
  const { innerHeight: height } = window;
  return (
    <Grid
      item
      xs={12}
      container
      height={"100%"}
      justifyContent="center"
      alignItems="center"
      sx={{
        backgroundColor: "#ffff",
      }}
    >
      <Box sx={{ zIndex: 10, width: height }} xs={12}>
        <Lottie animationData={error404Lottie} loop={true} />
      </Box>
    </Grid>
  );
};

export default Error404;
