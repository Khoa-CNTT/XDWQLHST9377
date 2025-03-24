import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import PropTypes from "prop-types";

function PageContent({ pathname }) {
  return (
    <Box
      sx={{
        py: 4,
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        textAlign: "center",
      }}
    >
      <Typography>Dashboard content for {pathname}</Typography>
    </Box>
  );
}

PageContent.propTypes = {
  pathname: PropTypes.string.isRequired,
};

export default PageContent;
