//
//  Bird.m
//  test
//
//  Copyright © 2019 frozenrainyoo. All rights reserved.
//

#import "Bird.h"

@implementation Bird

@synthesize duration;

// Add Missing Protocol Requirements
- (void)sing { 
    NSLog(@"Sing~~ %d", duration);
}

@end
