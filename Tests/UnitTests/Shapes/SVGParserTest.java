package Shapes;

import org.junit.Assert;
import org.junit.Test;

public class SVGParserTest {

    @Test
    public void illusionFromSVGTest() {
        String SVG1_Yes = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"828px\" height=\"437px\" viewBox=\"-0.5 -0.5 828 437\" content=\"&lt;mxfile modified=&quot;2019-01-08T15:41:01.964Z&quot; host=&quot;www.draw.io&quot; agent=&quot;Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36&quot; etag=&quot;OJhjLbhanzPTBIF17VGJ&quot; version=&quot;10.0.22&quot;&gt;&lt;diagram id=&quot;mZNr6_R3YRMUqTDTcL6z&quot; name=&quot;Page-1&quot;&gt;1ZZdT8IwFIZ/zS5NtnXTcSkIGpVI5MJ42axnW2O3Ll1hw19vZ7uPihi4MIQr2ren5/Q8bws4aJY39wKX2ZITYI7vksZBd47ve0GI1Eer7LQSIVcLqaDEBA3Cmn6CEbuwDSVQWYGScyZpaYsxLwqIpaVhIXhthyWc2VVLnMKesI4x21ffKJGZ6cK/GfQHoGnWVfauJ3olx12w6aTKMOH1SEJzB80E51KP8mYGrIXXcdH7FgdW+4MJKORRGxbvL8vnbbJOyer1UTZJ+DS/inSWLWYb07A5rNx1BKAgty1INSt4ocRpJnOmZp4aVlLwj56M6mmq9wPZwzqc0+u7V9cGeA5S7FRIPfANDbNshLbTBDAs6dZOj43NaZ+ur7DiVBX23cbaYK4jmrh2gopvRAxmz5jmjzSRH/6dSGKRgtxLpAajpgfp26wTjPP8I5xjTD2T1rE6oxLWJY7blVq9VNtFXJX67SS0AVV1mlDGZpxxMZhuyoGQ0JzqbMfMtZD5gZmPjI9+MT5yD3tsYT2ZIbp4ht7k3AyDi2cYnP0ehhfPMAzC/2KopsOPpP76HP5qoPkX&lt;/diagram&gt;&lt;/mxfile&gt;\" style=\"background-color: rgb(255, 255, 255);\"><defs/><path d=\"M 1 200 L 850 200\" fill=\"none\" stroke=\"#000000\" stroke-width=\"2\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"120\" cy=\"90\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"120\" cy=\"40\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"120\" cy=\"290\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"120\" cy=\"395\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/></svg>";
        Assert.assertTrue(SVGParser.decide(SVG1_Yes));
        String SVG2_Yes = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"828px\" height=\"512px\" viewBox=\"-0.5 -0.5 828 512\" content=\"&lt;mxfile modified=&quot;2019-01-08T15:43:53.650Z&quot; host=&quot;www.draw.io&quot; agent=&quot;Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36&quot; etag=&quot;zyJc15WEMefk8OVY6fhO&quot; version=&quot;10.0.22&quot;&gt;&lt;diagram id=&quot;mZNr6_R3YRMUqTDTcL6z&quot; name=&quot;Page-1&quot;&gt;1ZZNb6MwEIZ/DcdKGENDjpts2mq3VavmsNqjhQewajAyTiD99TVr8+GkWTWHKuIU+7VnxvO8mODhddHeS1LlT4IC9wKfth7+6QUBCiOsfzrlYJRFGBshk4zaTaOwZe9gRd+qO0ahdjYqIbhilSsmoiwhUY5GpBSNuy0V3K1akQxOhG1C+Kn6h1GVGzUOFqP+ACzL+8rodmlWCtJvtp3UOaGimUh44+G1FEKZUdGugXfwei4m7u7M6nAwCaX6UsDd3+enx326zejL6y/VptHvzY01Y0/4zjZsD6sOPQEo6Y8OpJ6VotTiKlcF1zOkh7WS4m0go3tamXigJ1jHc6Khe/3YgChAyYPe0ox8I8ssn6DtNQmcKLZ30xNrczakGyq8CKYLB37rBNjHES99N0EtdjIBGzOleZQmDqL/J1JEZqBOEunBpOlR+mfWBcah4AvOca6vSedYkzMF24ok3Uqjb6rrIqkrc3dS1oKuukoZ52vBhRxNt+VAKmgvdbZn5jvIgtDOJ8bHnxgf++c9drBezBDPjyHCLkS0vDbEcP4Qw6tDjOYH8eg2R4trM7ydH0N0BBFd/ZW4mD/EEH0bRD0dP9jMX/n42Ys3Hw==&lt;/diagram&gt;&lt;/mxfile&gt;\" style=\"background-color: rgb(255, 255, 255);\"><defs/><path d=\"M 1 250 L 850 250\" fill=\"none\" stroke=\"#000000\" stroke-width=\"2\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"120\" cy=\"140\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"170\" cy=\"90\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"170\" cy=\"390\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"120\" cy=\"470\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"220\" cy=\"40\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"220\" cy=\"310\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/></svg>";
        Assert.assertTrue(SVGParser.decide(SVG2_Yes));
        String SVG3_Yes = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"850px\" height=\"603px\" viewBox=\"-0.5 -0.5 850 603\" style=\"background-color: rgb(255, 255, 255);\"><defs/><path d=\"M 0 240 L 847 240\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"80\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"520\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"80\" rx=\"80\" ry=\"80\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><path d=\"M 500 80 L 300 80\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><path d=\"M 500 600 L 300 600\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"360\" rx=\"80\" ry=\"80\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/></svg>";
        Assert.assertTrue(SVGParser.decide(SVG3_Yes));
        String SVG4_Yes = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"850px\" height=\"543px\" viewBox=\"-0.5 -0.5 850 543\" style=\"background-color: rgb(255, 255, 255);\"><defs/><path d=\"M 0 200 L 847 200\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"40\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"480\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><path d=\"M 460 20 L 340 20\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><path d=\"M 460 540 L 340 540\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><path d=\"M 460 420 L 340 420\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><path d=\"M 460 60 L 340 60\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/></svg>";
        Assert.assertTrue(SVGParser.decide(SVG4_Yes));
        String SVG5_Yes = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"848px\" height=\"401px\" viewBox=\"-0.5 -0.5 848 401\" content=\"&lt;mxfile modified=&quot;2019-03-28T12:54:19.952Z&quot; host=&quot;www.draw.io&quot; agent=&quot;Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36&quot; etag=&quot;Znumhy4Kkgcs0T7dFN_g&quot; version=&quot;10.5.9&quot; type=&quot;device&quot;&gt;&lt;diagram id=&quot;6YRNdDurE8jUN5PciLOx&quot; name=&quot;Page-1&quot;&gt;tZTLbsMgEEW/xstKfjV2l22atpuqraIqa2ImBgkbC+NXvr64gB91oySLbCy4zAzMuWAnWGftq0AFeecYmOO7uHWCZ8f3Yz9U317otBCuIi2kgmIteaOwpUcwomvUimIoZ4GScyZpMRcTnueQyJmGhODNPOzA2XzXAqWwELYJYkt1R7Ektq1o1N+ApsTu7K0e9EqGbLDppCQI82YiBRsnWAvOpR5l7RpYz85y0XkvJ1aHgwnI5SUJu4/9Vxkda5KleVfR6DsuoztTpUasMg2bw8rOEoAcP/Yg1SznuRKfiMyYmnlqqKMBLyCOp/KGXtUdAZ6BFJ0KaUaa94YQmYC0mgCGJK3n5ZExNR3KDTt8cqo29l1z3QJL36aUvBIJmKgpLZtoL2640omnCkkkUpCLQmowaXOUfs24whj/AmMYU6+gN6QhVMK2QEm/0qh3ODcJlYV+GgfaAh5cq0FIaK/1rf3Dw/Dx7Hzia/yPr7F72sIZw2uBBeeBCcKzfVWeB3YDPmF4Mz5qOv5F9P0bf8XB5gc=&lt;/diagram&gt;&lt;/mxfile&gt;\" style=\"background-color: rgb(255, 255, 255);\"><defs/><g><path d=\"M 0 200 L 846 200\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"360\" cy=\"40\" rx=\"40\" ry=\"40\" fill=\"#ffffff\" stroke=\"#000000\" pointer-events=\"none\"/><path d=\"M 360 320 L 400 360 L 360 400 L 320 360 Z\" fill=\"#ffffff\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/></g></svg>";
        Assert.assertTrue(SVGParser.decide(SVG5_Yes));
    }
    @Test
    public void notIllusionFromSVGTest() {
        String SVG1_No = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"850px\" height=\"432px\" viewBox=\"-0.5 -0.5 850 432\" style=\"background-color: rgb(255, 255, 255);\"><defs/><path d=\"M 0 200 L 847 200\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"390\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"300\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"40\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/></svg>";
        Assert.assertFalse(SVGParser.decide(SVG1_No));
        String SVG2_No = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"850px\" height=\"543px\" viewBox=\"-0.5 -0.5 850 543\" style=\"background-color: rgb(255, 255, 255);\"><defs/><path d=\"M 0 200 L 847 200\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"40\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><ellipse cx=\"400\" cy=\"480\" rx=\"40\" ry=\"40\" fill=\"none\" stroke=\"#000000\" pointer-events=\"none\"/><path d=\"M 460 540 L 340 540\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><path d=\"M 460 420 L 340 420\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/><path d=\"M 460 39.5 L 340 39.5\" fill=\"none\" stroke=\"#000000\" stroke-miterlimit=\"10\" pointer-events=\"none\"/></svg>";
        Assert.assertFalse(SVGParser.decide(SVG2_No));
    }
}