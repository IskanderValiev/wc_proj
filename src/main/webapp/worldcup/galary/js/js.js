// $('.image-slider').slick();

$('.sl').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    fade: true,
    speed: 1500,
    asNavFor: '.sl2',
    waitForAnimate: false
});

$('.sl2').slick({
    slidesToShow: 7,
    arrows: false,
    centerMode: true,
    centerPadding:'40px',
    asNavFor: '.sl',
    focusOnSelect: true,
    waitForAnimate: false
});