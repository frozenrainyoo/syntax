//
//  ViewController.m
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import "ViewController.h"
#import "TestButton.h"
#import "Bird.h"
#import "Student.h"
#import "NSMutableArray+IntExt.h"

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];

    // Do any additional setup after loading the view.
    TestButton* testButton = [[TestButton alloc] initWithFrame:CGRectMake(50, 0, 100, 100)];
    [testButton setTitle:@"Test Protocol"];
    [self.view addSubview:testButton];
    [testButton setAction:@selector(clickTestButton:)];
    [testButton setTarget:self];

    TestButton* testCate = [[TestButton alloc] initWithFrame:CGRectMake(200, 0, 100, 100)];
    [testCate setTitle:@"Test Category"];
    [self.view addSubview:testCate];
    [testCate setAction:@selector(clickTestCateButton:)];
    [testCate setTarget:self];

    TestButton* testExtension = [[TestButton alloc] initWithFrame:CGRectMake(350, 0, 100, 100)];
    [testExtension setTitle:@"Test Extension"];
    [self.view addSubview:testExtension];
    [testExtension setAction:@selector(clickTestExtensionButton:)];
    [testExtension setTarget:self];
}


- (void)setRepresentedObject:(id)representedObject {
    [super setRepresentedObject:representedObject];

    // Update the view, if already loaded.
}

- (IBAction)clickTestButton:(id)sender {
    NSLog(@"%s", __func__);

    Bird* obj1 = [[Bird alloc] init];
    obj1.duration = 10;
    [obj1 sing];

    id<Singing> obj2 = [[Bird alloc] init];
    obj2.duration = 20;
    [obj2 sing];
}

- (IBAction)clickTestCateButton:(id)sender {
    NSLog(@"%s", __func__);

    Student* s1 = [[Student alloc] init];
    [s1 study];
    [s1 enroll];
}

- (IBAction)clickTestExtensionButton:(id)sender {
    NSLog(@"%s", __func__);

    NSMutableArray* array = [NSMutableArray array];
    [array addObject:@77];
    NSNumber *num = array[0];
    NSLog(@"num : %d", [num intValue]);
    
    [array addInt:88];
    num = array[1];
    NSLog(@"num2 : %d", [num intValue]);

    int value = [array intAtIndex:1];
    NSLog(@"num3 : %d", value);
}

@end
