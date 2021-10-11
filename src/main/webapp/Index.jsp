<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="Index.css">
<link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/77c4e13a1c.js" crossorigin="anonymous"></script>
</head>
<body>
    <div id="page-wrapper">
        <header id="header">
            <nav id="nav-bar">
                <div class="hamburger">
                    <div class="line"></div>
                    <div class="line"></div>
                    <div class="line"></div>
                </div>
                <ul class="nav-Links">
                    <li class="headerImage"><a class="nav-link" href="#"><img id="header-img" src="#" alt="logo"></a></li>
                    <li><a class="nav-link" href="#features">Products</a></li>
                    <li><a class="nav-link" href="#">User SignIn</a></li>
                    <li><a class="nav-link" href="Login.jsp">Admin SignIn</a></li>
                </ul>
            </nav>
        </header>
        <div class="content">
            <div class="container"></div>
            <section id="section1">
                <h1>COLOMBIAN HANDMADE CRAFTS</h1>
                <img class="craft" src="Canasto-guacamaya.png" alt="Colombian Handmade craft">
                <form id="form" action="#">
                    <input id="email" name="email" type="email" placeholder="Enter your email address" required><br>
                    <input class="btn" id="submit" type="submit" value="SUBSCRIBE">
                </form>
            </section>
            <div class="container">
                <section id="features">
                    <div class="grid">
                        <div class="icon"><i class="fas fa-shield-alt fa-5x"></i></div>
                        <div class="desc">
                            <h2>Purchase protected</h2>
                            <p>Piece of mind through the entire page, highly secure protocols</p>
                        </div>
                    </div>
                    <div class="grid">
                        <div class="icon"><i class="fas fa-money-bill-alt fa-5x"></i></div>
                        <div class="desc">
                            <h2>Best Value in the world</h2>
                            <p>Unique designs from the colombian culture at the best price</p>
                        </div>
                    </div>
                    <div class="grid">
                        <div class="icon"><i class="fas fa-hand-sparkles fa-5x"></i></div>
                        <div class="desc">
                            <h2>Handmade crafty</h2>
                            <p>100% guaranteed, with your purchase craft creators from are helped around the entire country</p>
                        </div>
                    </div>
                    <div class="grid">
                        <div class="icon"><i class="fas fa-car fa-5x"></i></div>
                        <div class="desc">
                            <h2>Shipping to your home</h2>
                            <p>No matter where you live, your crafty will arrive</p>
                        </div>
                    </div>
                </section>
            </div>
            <section id="video">
            	<iframe width="560" height="315" src="https://www.youtube.com/embed/4YW18cRYrKc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </section>
            <section id="pricing">
                <div class="product" id="mimbreLapm">
                    <div class="productTitle">Mimbre Lamp</div>
                    <img class="productImage" src="Mimbre_lamp.jpg" alt="Mimbre lamp">
                    <h2>$500</h2>
                    <ol>
                        <li>Perfect for home and Business</li>
                        <li>Mimbre material</li>
                        <li>Warm led light included</li>
                    </ol>
                    <button class="btn">Mine</button>
                </div>
                <div class="product" id="wayuuPurse">
                    <div class="productTitle">Wayuu Purse</div>
                    <img class="productImage" src="Wayuu_purse.jfif" alt="Wayuu Purse">
                    <h2>$450</h2>
                    <ol>
                        <li>Unique design for unique person</li>
                        <li>Black and white color</li>
                        <li>From native Wayuu culture </li>
                    </ol>
                    <button class="btn">Mine</button>
                </div>
                <div class="product" id="flowerVase">
                    <div class="productTitle">Mimbre Flower Vase</div>
                    <img class="productImage" src="mimbre-Flower_vase.png" alt="Exterior car coating image">
                    <h2>$400</h2>
                    <ol>
                        <li>Flowers are beatiful, they deserve the best clothes</li>
                        <li>Multi color desigh</li>
                        <li>Perfect for any environment</li>
                    </ol>
                    <button class="btn">Mine</button>
                </div>
            </section>
            <footer>
                <ul>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Privacy</a></li>
                    <li><a href="#">Terms</a></li>
                </ul>
                <span>Copyright 2021</span>
            </footer>
        </div>
    </div>
</body>
</html>
