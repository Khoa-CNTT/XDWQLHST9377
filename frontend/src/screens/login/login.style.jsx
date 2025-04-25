import { Box, Container } from "@mui/material";
import Grid from "@mui/material/Grid2";
import backgroundImage from "../../assets/imgs/background.png";

import MainCard from "../../components/cards";

export const AuthWrapper = ({ children }) => (
  <Box
    sx={{
      minHeight: "100vh",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      backgroundImage: `url(${backgroundImage})`,
      backgroundSize: "cover",
      backgroundRepeat: "no-repeat",
      bgcolor: "#1a3632",
    }}
    xs={12}
  >
    <Grid
      container
      justifyContent="center"
      alignItems="center"
      sx={{ height: "100%" }}
    >
      <Grid>
        <Box
          sx={{
            position: "relative",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <MainCard
            sx={{
              maxWidth: 320,
              margin: { xs: 2, md: 3 },
              zIndex: 10,
              borderRadius: 4,
            }}
            boxShadow
          >
            <Box sx={{ p: { xs: 2, sm: 3, md: 4, xl: 5 } }}>{children}</Box>
          </MainCard>
          <Container
            sx={{
              position: "absolute",
              zIndex: 8,
              maxWidth: 300,
              height: "25px",
              opacity: 0.08,
              bgcolor: "white",
              borderRadius: 4,
              top: 8,
            }}
          />
          <Container
            sx={{
              position: "absolute",
              zIndex: 6,
              maxWidth: 290,
              height: "90px",
              opacity: 0.06,
              bgcolor: "white",
              borderRadius: 4,
              bottom: 8,
            }}
          />
        </Box>
      </Grid>
    </Grid>
  </Box>
);
