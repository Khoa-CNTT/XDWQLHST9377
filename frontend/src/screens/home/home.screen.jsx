import React from "react";
import HomeHeader from "./home.header";
import HomeFooter from "./home.footer";
import HomeTestimonial from "./home.testimonial";
import "./index.css";

function HomePage() {
  return (
    <>
      <HomeHeader />
      <div className="max-w-7xl mx-auto pt-20 px-6">
        <HomeTestimonial />
        <HomeFooter />
      </div>
    </>
  );
}

export default HomePage;
