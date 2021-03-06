<!doctype html>
<html>
<head>
    <title>美国辣购网</title>
    <link rel="icon" href="./images/favicon.ico" type="image/x-icon">
    <meta charset="utf-8" />
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Add Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <!-- Add Google Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- CSS file -->
    <link rel="stylesheet" href="./stylesheets/styles.css">

    <!-- JavaScript file -->
    <script src="./js/myJavaScript.js"></script>

</head>

<body>

<!-- HTML code for top bar-->
<div class="top-bar">
    <div class="fixed-width-1">
        <div class="welcome">
            <div class="chinese-version-area">
                <span>Chinese Version 中文版</span>
            </div>
        </div>
        <div class="top-bar-li">
            <ul class="nav-top-bar">
                <li><i class="fa fa-sign-in"></i><span><a href="./signin.html">Sign In</a></span></li>
                <li><i class="fa fa-shopping-bag"></i><span>My Orders</span></li>
                <li><i class="fa fa-heart"></i><span>Wish List</span></li>
                <li><i class="fa fa-mobile"></i><span>WeChat</span></li>
                <li><i class="fa fa-info-circle"></i><span>Help</span></li>
            </ul>
        </div>
    </div>
</div>

<!-- HTML code for bar that contains main logo and search box-->
<div class="logo-search-bar">
    <div class="fixed-width-2">
        <div class="main-logo-area">
            <img class="main-logo" alt="" src="./images/new_logo.png" />
        </div>
        <div class="search-box-area">
            <input class="search-bar-main" type="search" placeholder="Search" >
            <button class="search-button-main" type="button">
                <i class="material-icons md-36" style="vertical-align:middle;" >search</i>
            </button>
        </div>
        <div class="shopping-cart-area">
            <button class="shopping-cart-button" type="button">
                <i class="fa fa-shopping-cart fa-2x" style="vertical-align:middle"></i>
                <span>Cart</span>
                <span>0</span>
            </button>
        </div>
    </div>
</div>

<!-- HTML code for bar contains all categories and shipping info-->
<div class="category-bar">
    <div class="fixed-width-3">
        <div class="all-category-area">
            <span>All Categories</span>
        </div>
        <div class="seperate-category-area">
            <ul class="seperate-category-ul">
                <li><span>Sign In</span></li>
                <li><span>My Orders</span></li>
                <li><span>Wish List</span></li>
                <li><span>WeChat</span></li>
                <li><span>Help</span></li>
            </ul>
        </div>
        <div class="shipping-info-area">
            <i class="material-icons md-24" style="vertical-align:middle">local_shipping</i>
            <span>Free Shipping on $50</span>
        </div>
    </div>
</div>

<!-- Blank div that is between featured items and chillibuy info -->
<div class="blank-div-bar">
</div>

<!-- Div for item images and several buttons-->
<div class="item-detail-bar">
    <div class="fixed-width-9">
        <div class="item-detail-img">
            <div class="sub-item-img-small">
                <div class="sub-item-img-small-list">
                    <img alt="" src="./images/Beta-AR-Jacket-Arctic-Fog-Back-View.jpg" />
                </div>
                <div class="sub-item-img-small-list">
                    <img alt="" src="./images/Beta-AR-Jacket-Arctic-Fog-Front-View.jpg" />
                </div>
                <div class="sub-item-img-small-list">
                    <img alt="" src="./images/Beta-AR-Jacket-Arctic-Fog-Hand-Pocket.jpg" />
                </div>
                <div class="sub-item-img-small-list">
                    <img alt="" src="./images/Beta-AR-Jacket-Arctic-Fog-Helmet-Compatible-Hood-Side-View.jpg" />
                </div>
                <div class="sub-item-img-small-list">
                    <img alt="" src="./images/Beta-AR-Jacket-Arctic-Fog-Chin-Guard.jpg" />
                </div>
                <div class="sub-item-img-small-list">
                    <img alt="" src="./images/Beta-AR-Jacket-Arctic-Fog-Pit-Zip.jpg" />
                </div>
            </div>
            <div class="sub-item-img-big">
                <img alt="" src="./images/Arcteryx_AR_JACKET_MEN.png" />
            </div>
        </div>
        <div class="item-shopping-info">
            <div class="item-detail-title">
                <span>Name: ${itemName}</span>
            </div>
            <div class="item-detail-type">
                <span>Brand: ${itemBrand}</span>
                <br />
                <span>Category: ${itemCategory}</span>
            </div>
            <div class="item-detail-price">
                <div class="item-detail-price-left">
                    <span>Price: ${itemPrice} USD</span>
                </div>
                <div class="item-detail-price-right">
                    <span>Rating: ${itemRating} Stars</span>
                </div>
            </div>
            <div class="item-detail-color">
                <div class="item-detail-color-info-div-left">
                    <span>Color: ${itemColor}</span>
                </div>
                <div class="item-detail-color-info-div-right">
                    <span>Id: ${itemId}</span>
                </div>
                <div class="item-detail-color-img-div">
                    <div class="item-detail-color-img">
                        <img alt="" src="./images/Beta-AR-Jacket-Admiral.png" />
                    </div>
                    <div class="item-detail-color-img">
                        <img alt="" src="./images/Beta-AR-Jacket-Anvil-Grey.png" />
                    </div>
                    <div class="item-detail-color-img">
                        <img alt="" src="./images/Beta-AR-Jacket-Black.png" />
                    </div>
                    <div class="item-detail-color-img">
                        <img alt="" src="./images/Beta-AR-Jacket-Phoenix.png" />
                    </div>
                    <div class="item-detail-color-img">
                        <img alt="" src="./images/Beta-AR-Jacket-Riptide.png" />
                    </div>
                    <div class="item-detail-color-img">
                        <img alt="" src="./images/Beta-AR-Jacket-Twinleaf.png" />
                    </div>
                </div>
            </div>
            <div class="item-detail-btn-area">
                <form class="form-item-detail-btn">
                    <div class="form-btn-size-qty">
                        <div class="form-btn-size">
                            <select class="form-size-select">
                                <option value="small">Small</option>
                                <option value="medium">Medium</option>
                                <option value="large">Large</option>
                                <option value="xlarge">XLarge</option>
                            </select>
                        </div>
                        <div class="form-btn-qty">
                            <select class="form-count-select">
                                <option value="1item">1</option>
                                <option value="2item">2</option>
                                <option value="3item">3</option>
                                <option value="4item">4</option>
                                <option value="5item">5</option>
                                <option value="6item">6</option>
                                <option value="7item">7</option>
                                <option value="8item">8</option>
                                <option value="9item">9</option>
                                <option value="10item">10</option>
                            </select>
                        </div>
                        <button type="submit" class="form-add-to-cart-btn"><span>Add to cart</span></button>
                    </div>
                </form>
            </div>
            <div class="item-detail-description">
                <span>Description: The streamlined Beta AR Jacket provides the backcountry minimalist with durable storm protection in a lightweight and packable format. This hip length GORE-TEX® Pro jacket reduces layering overlap and bulk, a helmet compatible DropHood™ offers quick storm protection, and reinforced shoulder and elbows survive alpine abuse.</span>
            </div>
        </div>
    </div>
</div>

</body>
